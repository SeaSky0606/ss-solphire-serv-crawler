package spring.data.mongodb.dao;

import static org.junit.Assert.fail;

import org.junit.Test;

import spring.data.mongodb.dao.FruitDao;
import spring.data.mongodb.dao.WarmaDao;
import spring.data.mongodb.pojo.Warma;

public class WarmaDaoTest {
	WarmaDao dao=new WarmaDao();
	@Test
	public void testSave() {
		FruitDao fruitDao = new  FruitDao();
		Warma ma = new Warma();
		ma.setFruits(fruitDao.findByCretira());
		ma.setName("ma001");
//		ma.setId(1);
		dao.save(ma);
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
		fail("Not yet implemented");
	}

}
