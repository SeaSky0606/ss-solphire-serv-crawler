package spring.data.mongodb.pojo;

/**
 * 
 * @author Administrator
 * @date 2016年7月2日
 */
public class People {
	private int id;
	private String name;
	private String sex;
	private String birthDate;

	public People() {
		super();
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public People(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public People(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birthDate=" + birthDate + "]";
	}

}
