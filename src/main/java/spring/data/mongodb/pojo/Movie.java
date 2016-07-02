package spring.data.mongodb.pojo;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author Administrator
 * @date 2016年7月2日
 */
public class Movie {
	
	@Id
	private String realId;
	
	private String name;




	public String getRealId() {
		return realId;
	}

	public void setRealId(String realId) {
		this.realId = realId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Movie() {
		super();
	}
	
	
}
