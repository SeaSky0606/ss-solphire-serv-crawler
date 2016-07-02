package spring.data.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import spring.data.mongodb.pojo.People;

import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;

public class PeopleDao {

	private static final String dbUrl = "mongodb://localhost/db_solphire_warma";
	private static final String COLLECTION_NAME = "t_people";
	BaseMongoRepository repo = new BaseMongoRepository(
			MongoTemplateFactory.getMongoTemplate(dbUrl));

	public boolean save(People p) {
		 repo.insert(p, COLLECTION_NAME);
		 return true;
	}

	public boolean update(People p) {
		Query query = new Query();
		Update update = new Update();
		int ret = repo.upsert(query, update, People.class);
		return ret > 0;
	}
	
	public boolean deleteById(int id){
		return repo.removeById(id, COLLECTION_NAME) > 0;
		
	}
	
	public List<People> list(){
		return null;
	}
	
	public void chec(){
		repo.createCollection("t_test001");
	}
}
