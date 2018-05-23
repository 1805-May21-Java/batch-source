package com.revature.OOPillars;

public class Snake extends Reptile{
	private String Breed;
	private boolean isVenomous;
	
	public Snake() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Snake(boolean liveBirth) {
		super(liveBirth);
		// TODO Auto-generated constructor stub
	}

	public Snake(int numOfLimbs, int numOfEyes, boolean isAlive, char gender) {
		super(numOfLimbs, numOfEyes, isAlive, gender);
		// TODO Auto-generated constructor stub
	}

	public String getBreed() {
		return Breed;
	}

	public void setBreed(String breed) {
		Breed = breed;
	}

	public boolean isVenomous() {
		return isVenomous;
	}

	public void setVenomous(boolean isVenomous) {
		this.isVenomous = isVenomous;
	}
	
	public void move (int unit) {
		System.out.println("The snake has slithered " + unit + " units.");
	}
	
	
}
