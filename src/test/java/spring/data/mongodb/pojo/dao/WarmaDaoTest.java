package spring.data.mongodb.pojo.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import spring.data.mongodb.pojo.People;

public class WarmaDaoTest {
	
	WarmaDao dao = new WarmaDao();
	
	@After
	public void out(){
		System.out.println("------ finish -------");
	}
	
	@Test
	public void testSave() {
//		dao.save(new People(1,"p1"));
		dao.save(new People(5,"p5"));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testChec() {
		dao.chec();
	}

}
