package com.revature.beans;

public class Vehicle {

//	these would be attributes that all vehicles would share
	protected int maxSpeed;
	protected int weightCapacity;
	protected int currentSpeed;
	protected boolean isOperating;
	
	public Vehicle() {
		super();
		this.isOperating = true;
	}
	
	public Vehicle(int maxSpeed, int weightCapacity, int currentSpeed, boolean isOperating) {
		this.maxSpeed = maxSpeed;
		this.weightCapacity = weightCapacity;
		this.currentSpeed = currentSpeed;
		this.isOperating = isOperating;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public int getMaxSpeed() {
		return this.maxSpeed;
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
		//this.currentSpeed = this.currentSpeed + increment;
		this.currentSpeed += increment;
		System.out.println("Vehicle has increased speed by "+increment);
		System.out.println("Current vehicle speed is "+this.currentSpeed);
	}
	
	public void slowDown(int decrement) {
		//this.currentSpeed = this.currentSpeed + decrement;
		this.currentSpeed -= decrement;
		System.out.println("Vehicle has decreased speed by "+decrement);
		System.out.println("Current vehicle speed is "+this.currentSpeed);
	}
	
	public static void staticMethod() {
		System.out.println("Static method from vehicle");
	}

}
