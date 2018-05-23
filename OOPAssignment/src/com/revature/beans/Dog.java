package com.revature.beans;

import com.revature.exceptions.NegativeWeightException;

public class Dog extends Animal{

// Attributes specific to Dogs 
	private short breed;
	private int numOfTricks;
	private boolean hasBone;

	public Dog() {
		super();
	}

//Dog is Inheriting attributes from its super class, Animal
	public Dog(int weight, int height, int age, short name) {
		super(weight, height, age, name);
	}

//The following getters and setters are an example of Encapsulation. The variables are private
//but the public methods here have access
	public short getBreed() {
		return breed;
	}

	public void setBreed(short breed) {
		this.breed = breed;
	}

	public int getNumOfTricks() {
		return numOfTricks;
	}

	public void setNumOfTricks(int numOfTricks) {
		this.numOfTricks = numOfTricks;
	}

	public boolean isHasBone() {
		return hasBone;
	}

	public void setHasBone(boolean hasBone) {
		this.hasBone = hasBone;
	}
	
	public void weightGain(int increment) {
		this.weight += increment;
		System.out.println("Dog has gained weight by " + increment);
		System.out.println("Dog's current weight is " + this.weight);
	}
	
	public void weightLoss(int decrement) {
		if (this.weight - decrement < 0) {
			try {
				throw new NegativeWeightException("Dog cannot have a weight of less than 0");
			} catch (NegativeWeightException e) {
				e.printStackTrace();
			}
		} else {
			this.weight -= decrement;
			System.out.println("Dog has lost weight by "+decrement);
			System.out.println("Dog's current weight is "+this.weight);
		}
	}

}
