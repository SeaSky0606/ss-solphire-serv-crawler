package seasky.solphire.crawler.dao;

import org.junit.After;
import org.junit.Test;
import seasky.solphire.crawler.pojo.TaotaoData;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/3/27.
 */
public class MysqlDaoTest {
    MysqlDao dao = new MysqlDao();

    @After
    public void tearDown() throws Exception {
        System.out.println("----End----");
    }

    @Test
    public void testAddMysql() throws Exception {
        TaotaoData taotaoData = new TaotaoData();
        taotaoData.setId("12333");
        taotaoData.setName("功夫之王");
        taotaoData.setActors("李连杰#刘亦菲");

        dao.addMysql(taotaoData);
    }

    @Test
    public void testSaveTaoList() throws Exception {

    }
}