package com.revature.animals;

import com.revature.interfaces.MakesNoise;

//Bird class inheriting from Animal and implementing MakesNoise interface
public class Bird extends Animals implements MakesNoise {

	//Variables
	private int numberOfLegs = 2;
	private boolean canFly = true;
	private boolean hasFeathers = true;
	
	//Methods
	public void noise() {
		System.out.println("The bird chirped!");
	}
	
	//the Bird class overloading the moves() method is an example of polymorphism
	public void moves() {
		if (canFly == true) {
			System.out.println("The bird flew!");
		} else {System.out.println("The bird moved!");}
	}

	//Constructors
	public Bird() {
		super();
	}
	
	public Bird(String favoriteFood) {
		super();
	}
	
	//Getters and Setters encapsulate data in class
	public boolean isHasFeathers() {
		return hasFeathers;
	}

	public void setHasFeathers(boolean hasFeathers) {
		this.hasFeathers = hasFeathers;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
}
