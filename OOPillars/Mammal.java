package com.revature.OOPillars;

public abstract class Mammal extends Animal {
	private final String speciesType = "warm_blooded";
	private boolean liveBirth = true;
	
	//Default Constructor
	public Mammal() {
		super();
	}
	public Mammal(int numOfLimbs, int numOfEyes, boolean isAlive, char gender) {
		super(numOfLimbs, numOfEyes, isAlive, gender);
	}

	//Constructor
	public Mammal(boolean liveBirth) {
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
