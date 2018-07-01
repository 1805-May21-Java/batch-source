package com.revature.beans;

public class Pokemon {
	
	int id;
	String name;
	String type;
	String evolutionStage;
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pokemon(int id, String name, String type, String evolutionStage) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.evolutionStage = evolutionStage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEvolutionStage() {
		return evolutionStage;
	}

	public void setEvolutionStage(String evolutionStage) {
		this.evolutionStage = evolutionStage;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", evolutionStage=" + evolutionStage + "]";
	}
	
	

}
