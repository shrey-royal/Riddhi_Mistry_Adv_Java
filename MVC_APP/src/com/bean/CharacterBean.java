package com.bean;

//POJO class
public class CharacterBean {
	private int characterId;
	private String characterName;
	private String creator;
	
	public int getId() {
		return characterId;
	}
	public void setId(int characterId) {
		this.characterId = characterId;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
