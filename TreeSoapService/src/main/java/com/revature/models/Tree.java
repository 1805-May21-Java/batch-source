package com.revature.models;

public class Tree {

	int id;
	int numberOfLeaves;
	String color;
	int ageInYears;

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tree(int id, int numberOfLeaves, String color, int ageInYears) {
		super();
		this.id = id;
		this.numberOfLeaves = numberOfLeaves;
		this.color = color;
		this.ageInYears = ageInYears;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfLeaves() {
		return numberOfLeaves;
	}

	public void setNumberOfLeaves(int numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAgeInYears() {
		return ageInYears;
	}

	public void setAgeInYears(int ageInYears) {
		this.ageInYears = ageInYears;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", numberOfLeaves=" + numberOfLeaves + ", color=" + color + ", ageInYears="
				+ ageInYears + "]";
	}

}