package com.revature.oopdemo;

public class Elephant extends Animal implements Vehicle {

	private int currentSpeed;
	private int maxSpeed;
	
	public Elephant(String name, int age, boolean isFriendly, int maxSpeed) {
		super(name, age, isFriendly);
		setMaxSpeed(maxSpeed);
		setHappyNoise("*High pitched trumpet noise*");
		setAngryNoise("*Low pitched trumpet noise*");
	}
	
	public Elephant(String name, int age, int maxSpeed) {
		super(name, age, true); //<- elephants by default are friendly
		setMaxSpeed(maxSpeed);
		setHappyNoise("*High pitched trumpet noise*");
		setAngryNoise("*Low pitched trumpet noise*");
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
	// Elephants implements slowDown so that the minimum speed is -1
	// Horses implements the same method differently.
	@Override
	public void slowDown(int increment) {
		if(currentSpeed - increment < -1) {
			System.out.println("The elephant cannot walk backwards faster than 1");
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

	// Abstraction
	// This class implements the makeNoise method differently from the other Animal sub-classes
	@Override
	void makeNoise() {
		System.out.println("*Trumpet noise*");
		
	}

}
