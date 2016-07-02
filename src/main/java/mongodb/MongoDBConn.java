package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * mongodb 链接测试
 * Created by junhong on 2016/3/28.
 */
public class MongoDBConn {

    public static void main(String[] args) throws Exception {
        System.out.println("--start--");
        @SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("hadoop2", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
        System.out.print(mongoDatabase.getName());
        System.out.println("  connected successfully!");

        System.out.println("验证/证明");
        for (MongoCredential credential : mongoClient.getCredentialsList()) {
            System.out.println(credential.getUserName() + "|" + credential.getPassword().toString());
        }
        System.out.println("----mongo db数据库：-----");
        for (String s : mongoClient.listDatabaseNames()) {
            System.out.println("db:" + s);
        }

        System.out.println("---- 输出'local'集合内部的documents -----");
        MongoCollection<Document> collection = mongoDatabase.getCollection("local");
        System.out.println("选中集合：" + collection);
        for (Document doc1 : collection.find()) {
            System.out.println(doc1);
        }

//        mongoDatabase.runCommand()
        List<Document> list = new ArrayList<Document>();
        Document doc = new Document("name", "test-doc").append("k1", "v1").append("k2", "v2");
        list.add(doc);
        collection.insertMany(list);

        System.out.println("-----重新打印集合 local 的全部文档------");
        collection = mongoDatabase.getCollection("local");
        for (Document doc2 : collection.find()) {
            System.out.println(doc2);
        }

        System.out.println("---Finish----");
    }

    public void createCollection(){

    }
    public void verify(){

    }

    public void ckDocuments(){

    }
}
