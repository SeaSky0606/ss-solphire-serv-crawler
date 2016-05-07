package seasky.solphire.crawler.dao;

import org.apache.log4j.Logger;
import seasky.solphire.crawler.pojo.History;
import seasky.solphire.crawler.pojo.TaotaoData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junhong on 2016/3/13.
 */
public class MysqlDao {
    final static Logger LOG = Logger.getLogger(MysqlDao.class);
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public MysqlDao() {

    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_seasky_recommand?characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "root", "1234");
            LOG.info("connectted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     *
     * @param history 观影记录
     * @return
     * @throws Exception
     */
    public int addHistory(History history) throws Exception {
        conn = getConnection();
        if (history == null) {
            return 0;
        }

        String sql = "insert into t_recommend(uid,gid,score) values(?,?,?)" +
                "ON DUPLICATE KEY UPDATE score=?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, history.getUid());
        ps.setInt(2, history.getGid());
        ps.setFloat(3, history.getScore());
        ps.setFloat(4, history.getScore());
        ps.execute();
        close();
        System.out.println("data added to mysql:" + history);
        return 0;
    }

    public int addMysql(TaotaoData tao) throws Exception {
        conn = getConnection();
        if (tao == null) {
            return 0;
        }

        String sql = "insert into t_movie(id,name,area,tag,onshow,actors,ave_score) values(?,?,?,?,?,?,?)" +
                "ON DUPLICATE KEY UPDATE name=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tao.getId());
        ps.setString(2, tao.getName());
        ps.setString(3, tao.getArea());
        ps.setString(4, tao.getTag());
        ps.setString(5, tao.getOnshow());
        ps.setString(6, tao.getActors());
        ps.setFloat(7, tao.getScore());
        ps.setString(8, tao.getName());
        ps.execute();
        close();
        LOG.info("data added to mysql:" + tao);
        System.out.println("data added to mysql:" + tao);
        return 0;
    }

    private void close() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int saveTaoList(List<TaotaoData> taoList) {
        if (taoList == null) {
            return 0;
        }
        for (TaotaoData data : taoList) {
            try {
                addMysql(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    /**
     * 更新多行数据
     *
     * @param taoList
     * @return
     */
    public int updateTaoList(List<TaotaoData> taoList) {
        if (taoList == null) {
            return 0;
        }
        for (TaotaoData data : taoList) {
            try {
                update(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public int update(TaotaoData tao) throws Exception {

        conn = getConnection();
        if (tao == null) {
            return 0;
        }

        String sql = "update t_movie set pic_url=?,detail=? where id=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tao.getPicUrl());
        ps.setString(2, tao.getDetail());
        ps.setString(3, tao.getId());
        ps.execute();
        close();
        LOG.info("data update to mysql:" + tao);
        System.out.println("data update to mysql:" + tao);

        return 1;
    }

    public List<String> queryColumn(String columnName) {
        List<String> lists = new ArrayList<String>();
        conn = getConnection();
        try {
            String sql = "select %s from t_movie where error=0 ";
            sql = String.format(sql,columnName);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lists.add(rs.getString(columnName));
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public TaotaoData get(String id) {

        TaotaoData data = new TaotaoData();
        conn = getConnection();
        try {
            String sql = "select * from t_movie where error=0 AND id=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                data.setId(rs.getString("id"));
                data.setPicUrl(rs.getString("pic_url"));

            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<TaotaoData> query() {
        List<TaotaoData> datas = new ArrayList<TaotaoData>();
        conn = getConnection();
        try {
            String sql = "select * from t_movie where error=0 limit 3800,50000";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TaotaoData data = new TaotaoData();
                data.setId(rs.getString("id"));
                data.setPicUrl(rs.getString("pic_url"));
                datas.add(data);
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
