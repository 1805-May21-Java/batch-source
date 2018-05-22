package com.revature.animals;

public class Mouse extends Animal{
	/* 
	 * Represents Inheritance in that the Mouse class extends the Animal class.This
	 * Allows Mouse to have variables such as numLimbs, speed, and age that are defined
	 * in the Animal class, but not explicitly in this class. Mouse also adopts Animal's
	 * public and protected methods, such as the getters, the setters, SpeedUp(int), and
	 * SlowDown(int)
	 */
	private String furDescription;
	
	//constructors
	public Mouse() {
		super();
	}
	public Mouse(int numLimbs, int speed, int maxSpeed, int age, String favoriteFood) {
		//This uses the field constructor of Animal to create a constructor
		super(numLimbs, speed, maxSpeed, age, favoriteFood);
	}
	public Mouse(String furDescription) {
		super();
		this.furDescription = furDescription;
	}
	
	//Overrides
	@Override
	public void speak() {
		System.out.println("Squeek!");
	}

	//Animal's SpeedUp(int) and SlowDown(int) are being overriden here
	@Override 
	public void speedUp(int speed) {
		super.speedUp(speed);
		System.out.println("The mouse is running at " + this.speed + " speed. What that means? I don't know.");
	}
	
	@Override
	public void slowDown(int speed) {
		super.slowDown(speed);
		System.out.println("The mouse is running at " + this.speed + " speed. What that means? I don't know.");
	}
	
	//Getters and Setters
	public String getFurDescription() {
		return furDescription;
	}
	public void setFurDescription(String furDescription) {
		this.furDescription = furDescription;
	}
	
	public void describeMe() {
		System.out.println("The mouse is " + this.furDescription + ".");
	}
	
	
}
