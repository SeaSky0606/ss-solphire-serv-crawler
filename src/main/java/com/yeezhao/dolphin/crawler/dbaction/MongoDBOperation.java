package com.yeezhao.dolphin.crawler.dbaction;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;

public class MongoDBOperation<T> implements DBBaseOperation<T> {

	private static final String DEFAULT_MONGODB_HOST = "mongodb://centos:27017/db_shop";
	private String collectionName = "t_book";

	BaseMongoRepository repo = null;

	@Override
	public boolean save(T t) {
		repo.insert(t, collectionName);
		return true;
	}

	@Override
	public boolean update(T t) {
//		repo.upsert(query, update, collectionName);
		return true;
	}

	@Override
	public T get(Object id) {
//		repo.getByIdentity(id, t , collectionName);
		return null;
	}

	@Override
	public T delete(Object id) {
		return null;
	}

	@Override
	public List<T> list() {
		DBCollection collection = repo.getCollection(collectionName);
		DBCursor data = collection.find();
		while(data.hasNext()){
			System.out.println(data.next());
		}
		return null;
	}

	@Override
	public long count() {
		return repo.doCount(new Query(), collectionName);
	}

	@Override
	public List<T> doQuery(Object query) {
		return null;
	}

	@Override
	public boolean conn() {
		String dbUrl = DEFAULT_MONGODB_HOST;
//		repo = BaseMongoTools.getInstance(dbUrl);
		MongoTemplate mongoTemplate = MongoTemplateFactory.getMongoTemplate(dbUrl);
		repo = new BaseMongoRepository(mongoTemplate);
		return repo != null;
	}
	
	

}
