package seasky.solphire.crawler.pojo;

public class Category {
	
	private int id;
	private String name;
	private double score;
	
	public Category(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", score=" + score
				+ "]";
	}
	
	

}
