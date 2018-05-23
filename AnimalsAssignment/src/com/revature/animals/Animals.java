package com.revature.animals;

import com.revature.interfaces.MakesNoise;

//Animals super class that implements MakesNoise interface
//Interface abstracts the noise method from the class and guarantees its implementation
public class Animals implements MakesNoise {
	
	//Variables
	int numberOfLegs;
	String favoriteFood;
	String name;
	boolean canFly;
	
	//Methods
	public void noise() {
		System.out.println("The animal made a noise!");
	}
	
	public void moves() {
		System.out.println("The animal moved!");
	}

	//Constructor
	public Animals() {
		super();
	}

	//Getters and Setters encapsulate data in class
	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
