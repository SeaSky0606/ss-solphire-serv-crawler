package spring.data.mongodb.dao;

import spring.data.mongodb.pojo.Movie;

import com.yeezhao.commons.mongo.base.MongoTemplateFactory;
import com.yeezhao.commons.mongo.cli.BaseMongoRepository;

public class MovieDao {

	private static final String dbUrl = "mongodb://localhost/db_solphire_warma";
	private static final String COLLECTION_NAME = "t_movie";
	BaseMongoRepository repo = new BaseMongoRepository(
			MongoTemplateFactory.getMongoTemplate(dbUrl));

	public boolean save(Movie movie) {
		repo.insert(movie, COLLECTION_NAME);
		return true;
	}

	public static void main(String[] args) {
		MovieDao dao = new MovieDao();
		Movie movie = new Movie();
//		movie.setrealId(12);
//		movie.setName("name12");
//		dao.save(movie);
		
		movie.setRealId("str1");
		movie.setName("name-str1");
		dao.save(movie);

	}

}
