package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Iterator;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class RetrievingAllDocuments {

	public static void main(String args[]) {

		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "C:\\data", "password".toCharArray());
		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("db");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("questions");
		System.out.println("Collection sampleCollection selected successfully");

//		Document document = new Document("title", "MongoDB").append("id", 1).append("description", "database")
//				.append("likes", 100)
//				.append("by", "tutorials point");
//		System.out.println("Create document successfully");
//		collection.insertOne(document);
//		document = new Document("title", "MongoDB").append("id", 2).append("description", "database")
//				.append("likes", 100).append("url", "http://www.tutorialspoint.com/mongodb/")
//				.append("by", "tutorials point");
//		System.out.println("Create document successfully");
//		collection.insertOne(document);
//		System.out.println("Document inserted successfully");

		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			i++;
		}
	}
}
