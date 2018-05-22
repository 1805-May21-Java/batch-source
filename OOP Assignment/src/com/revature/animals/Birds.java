package com.revature.animals;

//Inheritance - Inherits from the Animal class

public class Birds extends Animal {
	
	boolean canFly;

	public Birds() {
		super();
		canFly = true;
		}

	public Birds(int height, int weight, int numLegs, int xPosition, int yPosition) {
		super(height, weight, numLegs, xPosition, yPosition);
		canFly = true;
	}

	public Birds(boolean canFly) {
		super();
		this.canFly = canFly;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	@Override
	public void makeNoise() {	
		System.out.println("chirp");
	}

}
