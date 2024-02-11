package com.dao;

import org.bson.Document;

import com.bean.CharacterBean;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.util.DBConn;

public class CharacterDao {
	private MongoCollection<Document> collection = null;
	Document doc = null;
	
	public void insertCharacter(CharacterBean character) {
		collection = DBConn.getCollection();
		doc = new Document();
		
		doc.append("_id", character.getId())
			.append("characterName", character.getCharacterName())
			.append("creator", character.getCreator());
		
		try {
			collection.insertOne(doc);
			System.out.println("Successfully inserted document.");
		} catch (MongoWriteException mwe) {
			if(mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
					System.out.println("Document with that id already exists");
			}
		}
		DBConn.closeConnection();
	}
}
