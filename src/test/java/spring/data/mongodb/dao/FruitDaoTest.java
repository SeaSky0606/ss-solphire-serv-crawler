package spring.data.mongodb.dao;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Test;

import spring.data.mongodb.dao.FruitDao;
import spring.data.mongodb.pojo.Fruit;

public class FruitDaoTest {
	FruitDao dao = new FruitDao();

	@After
	public void outHint() {
		System.out.println("--finish---");
	}

	@Test
	public void testSave() {
		dao.save(new Fruit(UUID.randomUUID().toString(), "fruits002", 2.1,
				"this is description for 002."));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
//		dao.deleteById(id);
	}

	@Test
	public void testList() {
		dao.list();
	}
	
	@Test
	public void testFindByList() {
		List<Fruit> fruits = dao.findByCretira();
		for(Fruit f:fruits){
			System.out.println(f);
		}
	}
	
	@Test
	public void testChec() {
		fail("Not yet implemented");
	}
	public static void main(String[] args) {
		new FruitDaoTest().testSave();
	}

}
