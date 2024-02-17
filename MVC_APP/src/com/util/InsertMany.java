package com.util;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

class Character {
    String characterName;
    String creator;

    public Character(String characterName, String creator) {
        this.characterName = characterName;
        this.creator = creator;
    }
}

public class InsertMany {

	public static void main(String[] args) {
		ArrayList<Character> charactersList = new ArrayList<>();

        // Define characters and add them to the list
        charactersList.add(new Character("Mickey Mouse", "Walt Disney"));
        charactersList.add(new Character("Mario", "Shigeru Miyamoto"));
        charactersList.add(new Character("Darth Vader", "George Lucas"));
        charactersList.add(new Character("Harry Potter", "J.K. Rowling"));
        charactersList.add(new Character("Sherlock Holmes", "Arthur Conan Doyle"));
        charactersList.add(new Character("Indiana Jones", "George Lucas"));
        charactersList.add(new Character("Spider-Man", "Stan Lee"));
        charactersList.add(new Character("James Bond", "Ian Fleming"));
        charactersList.add(new Character("Homer Simpson", "Matt Groening"));
        charactersList.add(new Character("Bugs Bunny", "Tex Avery"));
        charactersList.add(new Character("SpongeBob SquarePants", "Stephen Hillenburg"));
        charactersList.add(new Character("Goku", "Akira Toriyama"));
        charactersList.add(new Character("Batman", "Bob Kane"));
        charactersList.add(new Character("Superman", "Jerry Siegel"));
        charactersList.add(new Character("Wonder Woman", "William Moulton Marston"));
        charactersList.add(new Character("Iron Man", "Stan Lee"));
        charactersList.add(new Character("Thor", "Stan Lee"));
        charactersList.add(new Character("Captain America", "Joe Simon"));
        charactersList.add(new Character("Hulk", "Stan Lee"));
        charactersList.add(new Character("Yoda", "George Lucas"));
        
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://mainHost:admin@cluster0.wt01dxv.mongodb.net/?retryWrites=true&w=majority")) {
            MongoDatabase database = mongoClient.getDatabase("cartoon");
            MongoCollection<Document> collection = database.getCollection("characters");

            // Insert each character document into the collection
            for (Character character : charactersList) {
                Document characterDoc = new Document("characterName", character.characterName)
                        .append("creator", character.creator);
                collection.insertOne(characterDoc);
            }

            System.out.println("Characters inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}

}
