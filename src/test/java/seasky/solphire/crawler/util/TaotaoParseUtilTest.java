package seasky.solphire.crawler.util;

import org.junit.After;
import org.junit.Test;

/**
 * Created by Administrator on 2016/3/27.
 */
public class TaotaoParseUtilTest {
    private TaotaoParseUtil util =  new TaotaoParseUtil();
    @After
    public void tearDown() throws Exception {
        System.out.println("--End---");
    }

    @Test
    public void testProcess2JSON() throws Exception {
        String url  = "http://www.dytt.com/search.asp?page=101";
        String html = new HtmlUtil().getJsonString(url);
//        String html = new HtmlUtil().getHtmlByUrl(url);
        System.out.println(html);
        System.out.println(util.process2JSON(html));
    }

    @Test
    public void testExtract() throws Exception {
        String url  = "http://www.dytt.com/xiazai/id20921.html";
        String html = new HtmlUtil().getJsonString(url);
        System.out.println(util.extract(html));
    }

    @Test
    public void testExtractTaoList() throws Exception {
        String url  = "http://www.dytt.com/search.asp?page=101";
        String html = new HtmlUtil().getJsonString(url);
        System.out.println(util.extractTaoList(html));
    }
}