package seasky.solphire.crawler.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.sun.javafx.collections.MappingChange;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by junhong on 2016/3/13.
 */
public class StringUtilTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsNullOrEmpty() throws Exception {
        String s = "test";
        System.out.println(StringUtil.isNullOrEmpty(s));
    }

    @Test
    public void testHttpClient() throws Exception {
        String url = "";


    }

    @Test
    public void testJsoup() throws Exception {
        String html = "<div class=\"endinfo\">\n" +
                "        <div class=\"pic\"><img src=\"http://tu.joy3g.com/20160311020831772.jpg\" alt=\"美人鱼3D\"></div>\n" +
                "        <div class=\"info\">\n" +
                "        <h1>美人鱼3D奇幻喜剧迅雷下载</h1>\n" +
                "       \t<ul>\n" +
                " \t\t\t<li><span>上映：</span>2016年 <span class=\"zt\">状态：</span>全集 </li>\n" +
                "            <li><span>类型：</span><a href=\"/search.asp?k=奇幻&amp;t=2\" target=\"_blank\">奇幻</a> <a href=\"/search.asp?k=剧情&amp;t=2\" target=\"_blank\">剧情</a> <a href=\"/search.asp?k=喜剧&amp;t=2\" target=\"_blank\">喜剧</a> <a href=\"/search.asp?k=爱情&amp;t=2\" target=\"_blank\">爱情</a> </li>\n" +
                "            <li><span>主演：</span><a href=\"/search.asp?searchword=%B5%CB%B3%AC\">邓超</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%C2%DE%D6%BE%CF%E9\">罗志祥</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%D5%C5%D3%EA%E7%B2\">张雨绮</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%C1%D6%D4%CA\">林允</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%CE%E2%D2%E0%B7%B2\">吴亦凡</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%C0%EE%C9%D0%D5%FD\">李尚正</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%CE%C4%D5%C2\">文章</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%B0%D7%BF%CD\">白客</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%BF%D7%C1%AC%CB%B3\">孔连顺</a>&nbsp;&nbsp;<a href=\"/search.asp?searchword=%D5%C5%C3%C0%B6%F0\">张美娥</a>&nbsp;&nbsp;</li>\n" +
                "            <li><span>地区：</span>香港</li>\n" +
                "\t\t\t<li><span>更新日期：</span>2016-3-11 2:08:17&nbsp;&nbsp;</li>\n" +
                "\t\t</ul>\n" +
                "        <div class=\"infobar\">\n" +
                "        <div class=\"starend pfen\">\n" +
                "        \t<span>影片评分：</span>\n" +
                "\t\t\t<div class=\"starscore\"><input type=\"hidden\" id=\"MARK_B1\" name=\"MARK_B1\" value=\"4876\">\n" +
                "\t\t\t\t<input type=\"hidden\" id=\"MARK_B2\" name=\"MARK_B2\" value=\"8.4\">\n" +
                "\t\t\t\t<input type=\"hidden\" id=\"MARK_B3\" name=\"MARK_B3\" value=\"40915\">\n" +
                "\t\t\t\t<div class=\"starA fl\" id=\"filmStar\">\n" +
                "\t\t\t\t\t<div class=\"starB s8\" id=\"start\"></div>\n" +
                "\t\t\t\t\t<div class=\"starC\" id=\"starTC\"> <a href=\"javascript:;\" onclick=\"OnStar(22297,1)\" onmouseout=\"kaifach()\" onmousemove=\"startm(1)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,2)\" onmouseout=\"kaifach()\" onmousemove=\"startm(2)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,3)\" onmouseout=\"kaifach()\" onmousemove=\"startm(3)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,4)\" onmouseout=\"kaifach()\" onmousemove=\"startm(4)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,5)\" onmouseout=\"kaifach()\" onmousemove=\"startm(5)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,6)\" onmouseout=\"kaifach()\" onmousemove=\"startm(6)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,7)\" onmouseout=\"kaifach()\" onmousemove=\"startm(7)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,8)\" onmouseout=\"kaifach()\" onmousemove=\"startm(8)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,9)\" onmouseout=\"kaifach()\" onmousemove=\"startm(9)\"></a> <a href=\"javascript:;\" onclick=\"OnStar(22297,10)\" onmouseout=\"kaifach()\" onmousemove=\"startm(10)\"></a> </div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<span class=\"no c1\" id=\"filmStarScore\">8<i>.4</i></span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"fen\" id=\"filmStarScoreTip\">比较精彩(4876评)</div>\n" +
                "        </div><script type=\"text/javascript\">markVideo(22297,4277,0,36105,5,0);</script>\n" +
                "        <div class=\"pl\">\n" +
                "        \t<div class=\"downing\">\n" +
                "           \t<div class=\"downbtn\">网盘下载合集</div>\n" +
                "           \t<div class=\"downbox\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<dl><dt>友情提示：</dt><dd>暂无网盘下载地址！</dd></dl>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "           \t</div>\n" +
                "           </div>\n" +
                "           <script>\n" +
                "           \t$(document).ready(function(){   \n" +
                "\t\t\t $(\".downing\").mouseover(function(){\n" +
                "\t\t\t  $(this).find(\".downbox\").show();\n" +
                "\t\t\t  })\n" +
                "\t\t\t  \n" +
                "\t\t\t $(\".downing\").mouseout(function(){\n" +
                "\t\t\t  $(this).find(\".downbox\").hide();\n" +
                "\t\t\t  })\n" +
                "\t\t\t})\n" +
                "           </script>\n" +
                "           <div class=\"fxshare\"><span><div class=\"bdsharebuttonbox bdshare-button-style0-16\" data-bd-bind=\"1457855476960\"><a href=\"#\" class=\"bds_more\" data-cmd=\"more\">分享到</a></div></span></div>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "        <div class=\"cr\"></div>\n" +
                "</div>";
        Document doc = Jsoup.parse(html);
        String pic = doc.select(".endinfo .pic").html();
        System.out.println("pic:" + pic);
    }

    @Test
    public void testFastJson() throws Exception {
        String json = "{'age':'18','sex':'男'}";
        String respond = "{\"ret\":0,\"state\":\"empty\",\"source\":\"百度百科\",\"category\":\"人物\"}";
        String source = JSONObject.parseObject(respond).getString("source");
        System.out.println(source);
        System.out.println("====***=====");


        ArrayList<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("pear");
        list.add("banana");


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("apple", "no.1");
        map.put("apple", "no.3");
        map.put("apple", "no.2");
//        System.out.println(JSONArray.parse(""));
    }

    @Test
    public void testHanLP() throws Exception {
        String s1 = " 基于此，一种新一开发模式诞生了！Kerkee框架是市面上独一无二的多主体共存的灵活混合型开发模型";
        String s2;
        Set<String> set1 = new HashSet<String>();
        for (Term term : StandardTokenizer.segment(s1)) {
            System.out.println("word:" + term.word);
            set1.add(term.word);
        }
        System.out.println(set1);


    }
}