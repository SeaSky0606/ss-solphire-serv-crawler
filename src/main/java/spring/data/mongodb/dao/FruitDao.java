package spring.data.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import spring.data.mongodb.pojo.Fruit;

import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;

public class FruitDao {

	private static final String dbUrl = "mongodb://localhost/db_solphire_warma";
	private static final String COLLECTION_NAME = "t_fruit";
	BaseMongoRepository repo = new BaseMongoRepository(
			MongoTemplateFactory.getMongoTemplate(dbUrl));

	public boolean save(Fruit p) {
		repo.insert(p, COLLECTION_NAME);
		return true;
	}

	public boolean update(Fruit p) {
		Query query = new Query();
		Update update = new Update();
		int ret = repo.upsert(query, update, Fruit.class);
		return ret > 0;
	}

	public boolean deleteById(int id) {
		return repo.removeById(id, COLLECTION_NAME) > 0;

	}

	public List<Fruit> list() {
//		repo.f
		return null;
	}
	
	public List<Fruit> findByCretira() {
		String propName = "price";
		double beginValue = 1.0;
		int batchSize = 5;
		return repo.findByBatch(Fruit.class, COLLECTION_NAME, propName,
				beginValue, batchSize);
	}

	public void chec() {
		repo.createCollection("t_test001");
	}
}
