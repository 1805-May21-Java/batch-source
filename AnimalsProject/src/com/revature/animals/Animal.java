package com.revature.animals;

//	Set this up as an abstract class that all subclasses can use as a blueprint
//	Sub classes will inherit the variables and concrete methods
//	For the abstract method moveAnimal, it is up to the individual class to define what it does

public abstract class Animal{

//	The variables to be inherited
	protected String food;
	protected String sound;
	protected int numOfLegs;
	
// Methods to be inherited that will also give the classes encapsulation with getters and setters
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public int getNumOfLegs() {
		return numOfLegs;
	}
	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
	
//	Abstract method to have its behavior defined by each sub class
	public abstract void moveAnimal();
	
}
