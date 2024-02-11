package com.util;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBConn {
	public static final String URI = "mongodb+srv://mainHost:admin@cluster0.wt01dxv.mongodb.net/?retryWrites=true&w=majority";
	public static MongoClient mongoClient = null;
//	MongoClient mongoClient = null;
	public static MongoDatabase database = null;
	public static MongoCollection<Document> collection = null;
	
	public static MongoCollection<Document> getCollection() {
		if(database == null) {
			try {
//				mongoClient = new MongoClient();	//localhost, 27017
				mongoClient = MongoClients.create(URI);
				database = mongoClient.getDatabase("cartoon");
				collection = database.getCollection("characters");
				System.out.println("Successful database connection established.");
			} catch (Exception e) {
				System.out.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return collection;
	}
	
	public static void closeConnection() {
		if(mongoClient != null) {
			mongoClient.close();
			System.out.println("Database connection closed.");
		}
	}
	
//	public static void main(String[] args) {
//		MongoCollection<Document> collection = DBConn.getCollection();
//		
//		DBConn.closeConnection();
//	}
}