package com.revature.beans;

public class Vehicle {

	//these would be attributes that all vehicles would share
	protected int maxSpeed;
	protected int weightCapacity;
	protected int currentSpeed;
	protected boolean isOperating;
	
	public Vehicle() {
		super();
	}
	
	//variable shadowing
	public Vehicle(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		this.maxSpeed = maxSpeed;
		this.weightCapacity = weightCapacity;
		this.currentSpeed = currentSpeed;
		this.isOperating = isOperating;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(int weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public boolean isOperating() {
		return isOperating;
	}

	public void setOperating(boolean isOperating) {
		this.isOperating = isOperating;
	}	
	
	public void speedUp(int increment) {
		
		this.currentSpeed = this.currentSpeed + increment;
		System.out.println("Vehicle has increased speed by " + increment);
		System.out.println("Current vehicle speed id " + this.currentSpeed);

	}

	public void slowDown(int decrement) {
		
		this.currentSpeed = this.currentSpeed + decrement;
		System.out.println("Vehicle has increased speed by " + decrement);
		System.out.println("Current vehicle speed id " + this.currentSpeed);

	}
	
	public static void staticMethod() {
		System.out.println("Declaring vehicle object as a vehicle");

		
	}
	
}
