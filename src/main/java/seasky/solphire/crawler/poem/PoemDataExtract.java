package seasky.solphire.crawler.poem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mortbay.log.Log;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;
import com.yeezhao.commons.util.StringUtil;

import seasky.solphire.crawler.util.HtmlUtil;

public class PoemDataExtract {
	private final static Logger LOG = Logger.getLogger(PoemDataExtract.class);
	public final static String GUSHIWEN_REQUEST_FORMAT = "http://so.gushiwen.org/view_%s.aspx"; // 7722
	private static final int FINAL_SIZE = 74000;
	private static final int START_INDEX = 19000;
	private static final int CUR_SIZE = 1000;
	private static final double SLEEP_STEP = 1000;

	public void start(int begin) {
		long start = System.currentTimeMillis();
		int cnt = 0;
		for (int index = begin; index < FINAL_SIZE; index++) {
			if (analyze("" + index)) {
				cnt++;
				if (cnt > CUR_SIZE)
					try {
						Thread.sleep((int) (SLEEP_STEP * Math.random()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}

		LOG.info("======= num of success crawler = " + cnt + " =====");
		Log.info(String.format("==== Total used time:%s (s) =====", (System.currentTimeMillis() - start) / 1000));
	}

	public boolean analyze(String id) {
		String request = String.format(GUSHIWEN_REQUEST_FORMAT, id);
		String html = "";
		try {
			byte[] bytes = HtmlUtil.fetchResult(request);
			if (bytes != null && bytes.length > 0) {
				html = new String(bytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> result = extract(html);
		result.put("_id", "gushiwen|" + id);
		result.put("update_time", new Date());
		System.out.println("result=" + result);
		return save(result);
	}

	private Map<String, Object> extract(String html) {
		Map<String, Object> map = new HashMap<>();
		Document doc = Jsoup.parse(html);
		Elements pingfen = doc.select(".pingfen").remove();
		// System.out.println(pingfen.text());
		Elements tagsEle = doc.select(".shisonconttag a").remove();
		String tags = "";
		List<String> tagList = new ArrayList<>();
		for (Element e : tagsEle) {
			tagList.add(e.text());
		}
		tags = join(tagList, "#");
		String title = doc.select(".shileft .son1 h1").text();
		Elements es = doc.select(".shileft .son2 p");
		int size = es.size();
		String content = "";
		String age = "";
		String author = "";
		// difference between "：" and ":"
		if (size > 2) {
			if (es.get(0).text().split("：").length >= 2) {
				age = es.get(0).text().split("：")[1];
				author = es.get(1).text().split("：")[1];
			}
		}

		if (size > 3) {
			for (int i = 3; i < size; i++) {

				String tmp = es.get(i).text(); // p[4 -> end]
				content += tmp;
			}
		}
		// System.out.println("con=" + content);
		for (Element e : es.remove()) {
			String paragraph = e.text();
			// System.out.println(paragraph);
		}

		if (StringUtil.isNullOrEmpty(content)) {
			content = doc.select(".shileft .son2").text();
		}
		// map.put("pingfen",pingfen);
		map.put("title", title);
		map.put("content", content);
		map.put("author", author);
		map.put("age", age);
		map.put("tags", tags);
		return map;
	}

	/**
	 * 
	 * @param list
	 * @param separator
	 * @return list拼接成 String by 'Character'
	 */
	public String join(List<String> list, String separator) {
		if (separator == null || list == null || list.size() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer("");
		for (String s : list) {
			sb.append(s + separator);
		}
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
	}

	public boolean clean(Map<String, Object> data) {

		return true;
	}

	// to db
	public boolean save(Map<String, Object> data) {
		String dbUrl = "mongodb://localhost:27017/db_poem";
		String collectionName = "t_poem";
		BaseMongoRepository repo = new BaseMongoRepository(MongoTemplateFactory.getMongoTemplate(dbUrl));
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(data.get("_id")));
		if (repo.doExist(query, collectionName)) {
			return false;
		}
		repo.insert(data, collectionName);
		return true;
	}

	/**
	 * 测试类型：【诗|词|曲|文言文|其他】
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int begin = START_INDEX;
		if (args.length > 0) {
			LOG.info("args=" + args[0]);
			begin = Integer.parseInt(args[0]);
		}
		new PoemDataExtract().start(begin);
	}

}
