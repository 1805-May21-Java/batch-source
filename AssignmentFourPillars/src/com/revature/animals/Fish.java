package com.revature.animals;

public class Fish extends Animal{
	private int numScales;
	
	//Constructors
	public Fish() {
		super();
	}
	public Fish(int numLimbs, int speed, int maxSpeed, int age, String favoriteFood) {
		super(numLimbs, speed, maxSpeed, age, favoriteFood);
	}
	public Fish(int numScales) {
		super();
		this.numScales = numScales;
	}
	
	//Overrides
	@Override
	public void speak() {
		System.out.println("Glub! Glub!");
	}
	
	@Override 
	public void speedUp(int speed) {
		super.speedUp(speed);
		System.out.println("The fish is swimming at " + this.speed + " speed. What that means? I don't know.");
	}
	
	@Override
	public void slowDown(int speed) {
		super.slowDown(speed);
		System.out.println("The fish is swimming at " + this.speed + " speed. What that means? I don't know.");
	}
	
	//Getters and Setters
	public int getNumScales() {
		return numScales;
	}
	public void setNumScales(int numScales) {
		this.numScales = numScales;
	}

	public void howScaly () {
		if (this.numScales < 100) {
			System.out.println("This fish isn't very scaly.");
		} else {
			System.out.println("This fish is VERY scaly!");
		}
	}
}
