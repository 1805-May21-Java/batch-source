package com.revature.oopdemo;

// This class is an example of Inheritance
// in that it inherits methods that
// and properties from the Animal class. Some of the methods are already implemented 
// and some are not. It also implements a interface that has methods that
// must be implemented.

public class Horse extends Animal implements Vehicle{
	private int maxSpeed;
	private int currentSpeed;
	
	public Horse(String name, int age, boolean isFriendly, int maxSpeed) {
		super(name, age, isFriendly);
		setMaxSpeed(maxSpeed);
		setHappyNoise("snort!");
		setAngryNoise("squeal!");
	}
	
	public Horse(String name, int age, int maxSpeed) {
		super(name, age);
		setMaxSpeed(maxSpeed);
		setHappyNoise("snort!");
		setAngryNoise("squeal!");
	}


	@Override
	public void speedUp(int increment) {
		if(currentSpeed + increment > maxSpeed) {
			System.out.println("The horse cannot exceed it's maximum speed");
			return;
		} 
		currentSpeed += increment;
		System.out.println("The speed increased by " + increment);
		
	}
	
	// This is an example of Polymorphism.
	// Horses implement slowDown so that the minimum is -3
	// Elephants implements it differently
	@Override
	public void slowDown(int increment) {
		if(currentSpeed - increment < -3) {
			System.out.println("The horse cannot walk backwards faster than 3");
			return;
		}
		currentSpeed -= increment;
		System.out.println("The speed decrease by " + increment);
		
	}

	@Override
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	@Override
	public int getMaxSpeed() {
		return maxSpeed;
	}

	@Override
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;	
	}

	@Override
	void makeNoise() {
		System.out.println("Neigh");
		
	}

	
}

	
