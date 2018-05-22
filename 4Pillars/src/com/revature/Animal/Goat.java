package com.revature.Animal;

public class Goat {
	private final int numOfEyes = 2;
	private final int numOfLegs = 4;
	public boolean canClimb;
	public boolean isCanClimb() {
		return canClimb;
	}
	public void setCanClimb(boolean canClimb) {
		this.canClimb = canClimb;
	}
	public int getNumOfEyes() {
		return numOfEyes;
	}
	public int getNumOfLegs() {
		return numOfLegs;
	}
	public Goat(boolean canClimb) {
		super();
		this.canClimb = canClimb;
	}
	public Goat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
