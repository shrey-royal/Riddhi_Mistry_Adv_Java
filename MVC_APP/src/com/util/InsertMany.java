package com.util;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

class Character {
	int characterId;
    String characterName;
    String creator;

    public Character(int characterId, String characterName, String creator) {
        this.characterId = characterId;
    	this.characterName = characterName;
        this.creator = creator;
    }
}

public class InsertMany {

	public static void main(String[] args) {
		ArrayList<Character> charactersList = new ArrayList<>();

        // Define characters and add them to the list
        charactersList.add(new Character(1, "Mickey Mouse", "Walt Disney"));
        charactersList.add(new Character(2, "Mario", "Shigeru Miyamoto"));
        charactersList.add(new Character(3, "Darth Vader", "George Lucas"));
        charactersList.add(new Character(4, "Harry Potter", "J.K. Rowling"));
        charactersList.add(new Character(5, "Sherlock Holmes", "Arthur Conan Doyle"));
        charactersList.add(new Character(6, "Indiana Jones", "George Lucas"));
        charactersList.add(new Character(7, "Spider-Man", "Stan Lee"));
        charactersList.add(new Character(8, "James Bond", "Ian Fleming"));
        charactersList.add(new Character(9, "Homer Simpson", "Matt Groening"));
        charactersList.add(new Character(10, "Bugs Bunny", "Tex Avery"));
        charactersList.add(new Character(11, "SpongeBob SquarePants", "Stephen Hillenburg"));
        charactersList.add(new Character(12, "Goku", "Akira Toriyama"));
        charactersList.add(new Character(13, "Batman", "Bob Kane"));
        charactersList.add(new Character(14, "Superman", "Jerry Siegel"));
        charactersList.add(new Character(15, "Wonder Woman", "William Moulton Marston"));
        charactersList.add(new Character(16, "Iron Man", "Stan Lee"));
        charactersList.add(new Character(17, "Thor", "Stan Lee"));
        charactersList.add(new Character(18, "Captain America", "Joe Simon"));
        charactersList.add(new Character(19, "Hulk", "Stan Lee"));
        charactersList.add(new Character(20, "Yoda", "George Lucas"));
        
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://mainHost:admin@cluster0.wt01dxv.mongodb.net/?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("cartoon");
            MongoCollection<Document> collection = database.getCollection("characters");

            // Insert each character document into the collection
            for (Character character : charactersList) {
                Document characterDoc = new Document("id", character.characterId).append("characterName", character.characterName).append("creator", character.creator);
                collection.insertOne(characterDoc);
            }

            System.out.println("Characters inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

}
