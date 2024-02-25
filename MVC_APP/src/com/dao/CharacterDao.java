package com.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.bean.CharacterBean;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.util.DBConn;

public class CharacterDao {
	private MongoCollection<Document> collection = DBConn.getCollection();
	Document doc = null;
	
	public void insertCharacter(CharacterBean character) {
		doc = new Document();
		
		doc.append("id", character.getId()).append("characterName", character.getCharacterName())
			.append("creator", character.getCreator());
		
		try {
			collection.insertOne(doc);
			System.out.println("Successfully inserted document.");
		} catch (MongoWriteException mwe) {
			if(mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
					System.out.println("Document with that id already exists");
			}
		}
	}
	
	public ArrayList<CharacterBean> getAllCharacters() {
        ArrayList<CharacterBean> characters = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
//                System.out.println(doc.toJson());
                CharacterBean character = new CharacterBean();
                character.setId(doc.getInteger("id"));
                character.setCharacterName(doc.getString("characterName"));
                character.setCreator(doc.getString("creator"));
                characters.add(character);
            }
            System.out.println("Data Fetched Successfully");
        } finally {
            cursor.close();
        }
        return characters;
    }
	
	public CharacterBean getCharacterById(int id) {
		CharacterBean character = null;		
		Document cursor = collection.find(Filters.eq("id", id)).first();
		try {
			if(cursor != null) {
				character = new CharacterBean();
				character.setId(cursor.getInteger("id"));
				character.setCharacterName(cursor.getString("characterName"));
                character.setCreator(cursor.getString("creator"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return character;
	}
	
	public boolean updateCharacter(CharacterBean character) {
		try {
			int id = character.getId();
			Document filter = new Document("id", id);
			Document update = new Document("$set", new Document("characterName", character.getCharacterName()).append("creator", character.getCreator()));
			collection.updateOne(filter, update);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCharacterById(int id) {
		try {			
			Document filter = new Document("id", id);
			DeleteResult res = collection.deleteOne(filter);
			long deletedDoc = res.getDeletedCount();
			if(deletedDoc == 1) {
				System.out.println("Data Deleted Successfully!");
				return true;
			} else {
				System.out.println("Failed to Delete Data!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}