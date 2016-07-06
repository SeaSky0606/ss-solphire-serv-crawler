package elastic.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yeezhao.dolphin.sealion.param.IndexParam;
import com.yeezhao.dolphin.sealion.server.IndexEsService;

/**
 * 
 * @author Administrator
 * @since 2016年7月6日 下午6:17:26
 */
public class IndexService {

	private static final String indexName = "yz-test";
	private static final String indexType = "yz-test";
	private static final String esClusterName = "cjh-application";
	private static final String esHosts = "localhost:9300";

	private static final Logger LOG = Logger.getLogger(IndexService.class);
	private List<Map<String, Object>> datas;

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}

	// 初始测试数据
	public void init() {
		List<Map<String, Object>> datas = new ArrayList<>();
		List<Book> books = new ArrayList<>();
		books.add(new Book(5, "this is 5", "a1"));
		books.add(new Book(4, "not only", "a1"));
		books.add(new Book(6, "before see you", "a1"));
		for (Book book : books) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", book.id);
			map.put("name", book.name);
			map.put("author", book.author);
			datas.add(map);

		}
		LOG.info(datas);
		LOG.info(datas.size());
		setDatas(datas);
	}

	public boolean write() {
		IndexEsService es = IndexEsService.getInstance(esClusterName, esHosts);
		IndexParam indexParam = new IndexParam(indexName, indexType, datas);
		es.index(indexParam);
		return true;
	}

	class Book {
		int id;
		String name;
		String author;

		public Book(int id, String name, String author) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
		}

		public Book() {
			super();
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
		}

	}

}
