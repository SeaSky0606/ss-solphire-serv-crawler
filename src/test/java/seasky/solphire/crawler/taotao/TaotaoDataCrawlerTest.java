package seasky.solphire.crawler.taotao;

import org.junit.After;
import org.junit.Test;
import seasky.solphire.crawler.dao.MysqlDao;
import seasky.solphire.crawler.pojo.TaotaoData;
import seasky.solphire.crawler.util.StringUtil;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/3/27.
 */
public class TaotaoDataCrawlerTest {
    TaotaoDataCrawler dataCrawler = new TaotaoDataCrawler();
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCrawl() throws Exception {
        String id = "101";
        System.out.println(dataCrawler.crawl(id));
    }

    @Test
    public void testGetData() throws Exception {
        System.out.println("md5(Hey):"+ StringUtil.genMD5Val("Hey"));
        System.out.println(dataCrawler.getData().size());
    }
    @Test
    public void testCrawlMore() throws  Exception{
        String id="1";
        System.out.println(dataCrawler.crawlMore(id));
    }

    @Test
    public void testCrawlMoreAndPics() throws  Exception{

        System.out.println(dataCrawler.crawlMore("1"));
//        System.out.println(dataCrawler.crawlPics(new MysqlDao().get("1")));
    }
}