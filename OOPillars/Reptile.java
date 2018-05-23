package com.revature.OOPillars;

public abstract class Reptile extends Animal{
	private final String speciesType = "cold-blooded";
	private boolean liveBirth = false;
	
	// Default constructor
	public Reptile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reptile(int numOfLimbs, int numOfEyes, boolean isAlive, char gender) {
		super(numOfLimbs, numOfEyes, isAlive, gender);
		// TODO Auto-generated constructor stub
	}
	
	public Reptile(boolean liveBirth) {
		super();
		this.liveBirth = liveBirth;
	}
	public boolean isLiveBirth() {
		return liveBirth;
	}
	public void setLiveBirth(boolean liveBirth) {
		this.liveBirth = liveBirth;
	}
	public String getSpeciesType() {
		return speciesType;
	}
	
}
