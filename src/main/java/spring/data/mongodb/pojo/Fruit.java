package spring.data.mongodb.pojo;

public class Fruit {

	private String uuid;
	private String name;
	private double price;
	private String description;
	@Override
	public String toString() {
		return "Fruit [uuid=" + uuid + ", name=" + name + ", price=" + price
				+ ", description=" + description + "]";
	}
	public Fruit(String uuid, String name, double price, String description) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public Fruit() {
		super();
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
