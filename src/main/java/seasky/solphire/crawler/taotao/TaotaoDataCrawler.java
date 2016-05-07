package seasky.solphire.crawler.taotao;

import seasky.solphire.crawler.dao.MysqlDao;
import seasky.solphire.crawler.pojo.TaotaoData;
import seasky.solphire.crawler.util.HtmlUtil;
import seasky.solphire.crawler.util.TaotaoParseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫（http://www.dytt.com)步骤
 * 1）根据分页爬取全部id摘要
 * 2）根据id补充详细p
 * 3) 根据pic_url存储图片
 * Created by junhong on 2016/3/13.
 */
public class TaotaoDataCrawler {


    private static final int TOTAL_PAGE = 1138 + 12;
    private static final String URL_FORMAT = "http://www.dytt.com/search.asp?page=%s";
    private static final String DETAIL_FORMAT = "http://www.dytt.com/xiazai/id%s.html";

    public static void main(String[] args) throws Exception {
//        System.out.println("total valid page:" + new TaotaoDataCrawler().crawl());
        long startTime = System.currentTimeMillis();
//        System.out.println("total valid page:" + new TaotaoDataCrawler().crawlMore());
        System.out.println("total valid page:" + new TaotaoDataCrawler().crawlPics());
        System.out.println("Time total used:" + (System.currentTimeMillis() - startTime));
    }

    /**
     * @return 根据分页抓取全部电影id
     */
    public int crawl() {
        int cnt = 0;
        for (String id : getData()) {
            cnt += crawl(id);
        }
        return cnt;
    }

    /**
     * @return 爬取 pic_url和detail
     */
    public int crawlMore() {
        for (String id : getSeedsFromMysql()) {
            crawlMore(id);
        }
        return 1;
    }

    /**
     * @return 写入图片
     * @throws Exception
     */
    public int crawlPics() throws Exception {
        for (TaotaoData data : getPojoFromMysql()) {
            crawlPics(data);
        }
        return 1;
    }

    public int crawlPics(TaotaoData data) {
        try{

        new HtmlUtil().writePic2NativeWithId(data.getId(), data.getPicUrl());
        }catch(Exception e){
            System.out.println("now id is :"+data.getId()+", url is:"+data.getPicUrl());
            e.printStackTrace();
        }
        return 1;
    }

    private List<TaotaoData> getPojoFromMysql() {
        return new MysqlDao().query();
    }

    public int crawlMore(String id) {
        TaotaoParseUtil util = new TaotaoParseUtil();
        HtmlUtil htmlUtil = new HtmlUtil();
        String url = String.format(DETAIL_FORMAT, id);
        String html = "";
        try {
            html = htmlUtil.getJsonString(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaotaoData tao = util.extract(html);
        tao.setId(id);

        if (tao != null) {
            try {
                return new MysqlDao().update(tao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List<String> getSeedsFromMysql() {
        return new MysqlDao().queryColumn("id");
    }

    public List<String> getData() {
        ArrayList<String> pns = new ArrayList<String>();
        for (int pn = 1; pn <= TOTAL_PAGE; pn++) {
            pns.add(String.valueOf(pn));
        }
        return pns;
    }

    public int crawl(String id) {
        TaotaoParseUtil util = new TaotaoParseUtil();
        HtmlUtil htmlUtil = new HtmlUtil();
        String url = String.format(URL_FORMAT, id);
        String html = "";
        try {
            html = htmlUtil.getJsonString(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<TaotaoData> taoList = util.extractTaoList(html);

        if (taoList != null) {
            return new MysqlDao().saveTaoList(taoList);
        }
        return 0;
    }

}
