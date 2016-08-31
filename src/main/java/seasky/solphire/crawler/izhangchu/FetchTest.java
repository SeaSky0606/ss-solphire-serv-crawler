package seasky.solphire.crawler.izhangchu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;

public class FetchTest {
	private final static String HTTP_DISH_URL_FORMAT = "http://www.izhangchu.com/dish/%s.html";
	private final static String HTTP_CATEGORY_URL_FORMAT = "http://www.izhangchu.com/category/%s.html";
	private final static int TINY_TEST_SIZE = 10;
	private final static int MID_TEST_SIZE = 1000;
	private final static int LARGET_TEST_SIZE = 10000;
	private static final int SUCCESS_RESPONSE_CODE = 200;

	public static byte[] fetch(String request) throws Exception {
		URL url = new URL(request);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		int responseCode = conn.getResponseCode();
		if (responseCode != 200) {
			return null;
		}
		InputStream in = conn.getInputStream();
		return IOUtils.toByteArray(in);
	}

	public static boolean saveVideo(byte[] b) throws Exception {
		// File file = new File("c://text-a" + System.currentTimeMillis() % 100
		// + ".txt");
		File file = new File("c://video-a" + System.currentTimeMillis() % 100 + ".mp4");
		if (file.exists()) {
			return false;
		}
		OutputStream out = new FileOutputStream(file);
		out.write(b);
		return true;
	}

	public static boolean curl(String request) throws Exception {
		URL url = new URL(request);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		int responseCode = conn.getResponseCode();
		return responseCode == SUCCESS_RESPONSE_CODE;
	}

	public static void main(String[] args) throws Exception {
//		fetchMP4();
		 System.out.println("=== start ===");
		 long start = System.currentTimeMillis();
		 test1();
		 System.out.println("total used time=" + (System.currentTimeMillis() -
		 start) / 1000 + " second(s)");
	}

	private static void fetchMP4() throws Exception {
		String request = "http://video.szzhangchu.com/hongyouniubaiyeB.mp4";
		byte[] result = fetch(request);
		if (result != null) {
			System.out.println(saveVideo(result));
		}
		System.out.println("-- finish --");
	}

	private static void test0() throws Exception {
		String id = "14634";
		String request = String.format(HTTP_CATEGORY_URL_FORMAT, id);
		if (curl(request)) {
			System.out.println(saveId(id, "t_dish"));
		}
	}

	public static void test1() throws Exception {
		int cnt = 0;
		for (int i = 1; i <= MID_TEST_SIZE; i++) {
			String request = String.format(HTTP_CATEGORY_URL_FORMAT, i + "");
			if (curl(request)) {
				cnt++;
				saveId(i + "", "t_category");
				// saveId(i + "", "t_dish");
			}
		}
		System.out.println("cnt=" + cnt);
		
		int cnt2 = 0;
		for (int i = 1; i <= LARGET_TEST_SIZE; i++) {
			String request = String.format(HTTP_DISH_URL_FORMAT, i + "");
			if (curl(request)) {
				cnt2++;
				saveId(i + "", "t_category");
				// saveId(i + "", "t_dish");
			}
		}
		System.out.println("cnt2=" + cnt2);
	}

	static String dbUrl = "mongodb://localhost:27017/db_izhangchu";
	static BaseMongoRepository repo = new BaseMongoRepository(MongoTemplateFactory.getMongoTemplate(dbUrl));

	public static boolean saveId(String id, String collectionName) {
		Map<String, Object> map = new HashMap<>();
		map.put("_id", id);
		map.put("update_time", new Date());
		repo.insert(map, collectionName);
		return true;
	}

}
