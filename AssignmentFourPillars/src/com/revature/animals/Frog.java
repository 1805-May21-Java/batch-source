package com.revature.animals;

public class Frog extends Animal{
	private int slimeRating;	
	
	//Constructors
	public Frog() {
		super();
	}
	public Frog(int numLimbs, int speed, int maxSpeed, int age, String favoriteFood) {
		super(numLimbs, speed, maxSpeed, age, favoriteFood);
	}
	public Frog(int slimeRating) {
		super();
		this.slimeRating = slimeRating;
	}
	
	//Overrides
	@Override
	public void speak() {
		System.out.println("Ribbit!");
	}
	
	@Override 
	public void speedUp(int speed) {
		super.speedUp(speed);
		System.out.println("The frog is hopping at " + this.speed + " speed. What that means? I don't know.");
	}
	
	@Override
	public void slowDown(int speed) {
		super.slowDown(speed);
		System.out.println("The frog is hopping at " + this.speed + " speed. What that means? I don't know.");
	}
	
	//Getters and Setters
	public int getSlimeRating() {
		return slimeRating;
	}
	public void setSlimeRating(int slimeRating) {
		this.slimeRating = slimeRating;
	}
	
	public void rateMySlime() {
		System.out.println("This frog has a slime rating of " + this.slimeRating + ".");
	}

}
