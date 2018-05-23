package com.revature.animals;

import com.revature.interfaces.MakesNoise;

//Dog class that extends Animals and implements MakesNoise
public class Dog extends Animals implements MakesNoise {

	//Variables
	private int numberOfLegs = 4;
	private final boolean canFly = false;
	private boolean hasFur = true;
	
	//Methods
	public void noise() {
		System.out.println("The dog barked!");
	}
	
	//the Dog class overloading the moves() method is an example of polymorphism
	public void moves() {
		System.out.println("The dog ran!");
	}
	
	//Constructors
	public Dog() {
		super();
	}
	
	public Dog(String favoriteFood) {
		super();
	}

	//Getters and Setters encapsulate data in class
	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	
}
