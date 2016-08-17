package seasky.solphire.crawler.poem;

/**
 * 古诗文
 * 
 * @author Administrator -> junhong
 * @since 2016年8月17日 上午8:11:36
 */
public class Poem {

	private String id;
	private String author;
	private String age;
	private String content;
	private String type;

	@Override
	public String toString() {
		return "Poem [id=" + id + ", author=" + author + ", age=" + age + ", content=" + content + ", type=" + type
				+ "]";
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getAge() {
		return age;
	}

	public String getContent() {
		return content;
	}

	public String getType() {
		return type;
	}

	public Poem(String id, String author, String age, String content, String type) {
		super();
		this.id = id;
		this.author = author;
		this.age = age;
		this.content = content;
		this.type = type;
	}

}
