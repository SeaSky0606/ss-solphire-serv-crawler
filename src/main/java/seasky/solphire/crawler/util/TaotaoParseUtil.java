package seasky.solphire.crawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import seasky.solphire.crawler.pojo.TaotaoData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by junhong on 2016/3/13.
 */

public class TaotaoParseUtil {
    final static String URL_FORMAT = "http://www.dytt.com/search.asp?page=%s";
    final static String PIC_FORMAT = "http://tu.joy3g.com/%s.jpg";
    final static String REG1 = "/xiazai/id(.*?).html"; // "/xiazai/id7042.html";
    final static String REG2 = "title=\"(.*?)\""; // "title="张震讲故事之鬼迷心窍"";
    final static String REG3 = "src=\"(.*?)\"";

    public String process2JSON(String html) {
        return null;
    }

    public List<String> extractList(String html) {
        String css = ".movielist li";
        ArrayList<String> lists = new ArrayList<String>();
        Document doc = Jsoup.parse(html);
        for (Element e : doc.select(css)) {
            lists.add(e.html());
        }
        return lists;
    }

    public TaotaoData extract(String html) {
        Document doc = Jsoup.parse(html);
        System.out.println(html);
        String pic = doc.select(".movie .pic").html();
        pic = getTarFromReg(pic, REG3);
        String detail = doc.select(".smalltext").html().trim().replaceAll("\\s", "");
        System.out.println("pic:" + pic + ",    detail:" + detail);
        TaotaoData data = new TaotaoData();

        if (!StringUtil.isNullOrEmpty(pic)) {
            data.setPicUrl(pic);
        }
        if (!StringUtil.isNullOrEmpty(detail)) {
            data.setDetail(detail);
        }
        return data;
    }

    /**
     * @param html
     * @return
     */


    public List<TaotaoData> extractTaoList(String html) {
        if (StringUtil.isNullOrEmpty(html)) {
            return null;
        }
        List<TaotaoData> datas = new ArrayList<TaotaoData>();

        for (String s : extractList(html)) {
            TaotaoData data = new TaotaoData();
            if (!StringUtil.isNullOrEmpty(getTarFromReg(s, REG1))) {
                data.setId(getTarFromReg(s, REG1));
            }
            if (!StringUtil.isNullOrEmpty(getTarFromReg(s, REG2))) {
                data.setName(getTarFromReg(s, REG2));
            }
            Document doc = Jsoup.parse(s);
            Elements elements = doc.select("p");
//            for (Element element : elements) {
//                System.out.println(element.text());
//            }


            //    1280超清《宅女侦探桂香》
            //    2015
            //    大陆 
            //    5.1
            //    爱情片
            //    王珞丹,周渝民,任达华,鲍起..
            //    15-09-09
            data.setOnshow(elements.get(1).html());
            data.setArea(elements.get(2).html().replaceAll("&nbsp;", ""));
            data.setScore(Float.valueOf(elements.get(3).html()));
            data.setTag(elements.get(4).html());
            data.setActors(elements.get(5).html().replaceAll("&middot;", ""));

            datas.add(data);
        }

        return datas;
    }

    public String getTarFromReg(String source, String reg) {
        Pattern pa = Pattern.compile(reg);
        Matcher matcher = pa.matcher(source);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }


}


