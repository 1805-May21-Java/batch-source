package com.adora.beans;

public class Chocolate {

	int id;
	String company;
	int calories;
	String type;
	
	public Chocolate() {
		super();
	}

	public Chocolate(int id, String company, int calories, String type) {
		super();
		this.id = id;
		this.company = company;
		this.calories = calories;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Chocolate [id=" + id + ", company=" + company + ", calories=" + calories + ", type=" + type + "]";
	}

	
	

}
