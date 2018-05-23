package com.revature.oop.demonstration;

public class Animal implements Eat { // Example of inheritance. Animal inherits the abstract method eat().

	protected boolean hasFur; // Declares boolean hasFur is only available to same Class, Package, Package non-subclass, another package's subclass
	protected boolean hasTail; // ''
	protected boolean isAlive; // ''
	protected int numLegs; // ''
	protected int averageWeight; // ''
	
	
	public Animal() {
		super();
	}
	
	public Animal (int numLegs, boolean hasFur, boolean hasTail, int averageWeight) {
		this.numLegs = numLegs;
		this.hasFur = hasFur;
		this.hasTail = hasTail;
		this.averageWeight = averageWeight;
		
	}
	
	//Getters and Setters
	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	public boolean isHasTail() {
		return hasTail;
	}

	public void setHasTail(boolean hasTail) {
		this.hasTail = hasTail;
	}

	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getAverageWeight() {
		return averageWeight;
	}

	public void setAverageWeight(int averageWeight) {
		this.averageWeight = averageWeight;
	}
	// End Getters and Setters
	public void eat() { // This will later be used to demonstrate polymorphism
		System.out.println("All animals must eat to survive"); //Declares eat() with a default string for any animal that doesn't override with it's own.
	}

}
