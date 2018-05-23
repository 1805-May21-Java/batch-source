package com.revature.OOPillars;


public abstract class Animal {
	protected int numOfLimbs;
	protected int numOfEyes;
	protected boolean isAlive;
	protected char gender;

	// Default Constructor
	public Animal() {
		super();
	}
	
	// Constructor
	public int getNumOfLimbs() {
		return numOfLimbs;
	}


	public Animal(int numOfLimbs, int numOfEyes, boolean isAlive, char gender) {
		super();
		this.numOfLimbs = numOfLimbs;
		this.numOfEyes = numOfEyes;
		this.isAlive = isAlive;
		this.gender = gender;
	}
	
	public void setNumOfLimbs(int numOfLimbs){
		
		this.numOfLimbs = numOfLimbs;
	}

	public int getNumOfEyes() {
		return numOfEyes;
	}

	public void setNumOfEyes(int numOfEyes) {
			this.numOfEyes = numOfEyes;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public void move(int distance) {
		System.out.println("Animal is moving " + distance + " units...");
	}
	
		
}
