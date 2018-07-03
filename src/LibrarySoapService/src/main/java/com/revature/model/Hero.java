package com.revature.model;

public class Hero {
	private long id;
	
	private String name;
	
	private String localizedName;
	
	public Hero() {
		
	}
	
	public Hero(String name, long id, String localizedName) {
		this.name = name;
		this.id = id;
		this.localizedName = localizedName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}
	
	
	
}
