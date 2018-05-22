package com.revature.oop.demonstration;

public class Animal {

	protected boolean hasFur;
	protected boolean hasTail;
	protected int numLegs;
	protected boolean isAlive;
	
	
	public Animal() {
		super();
		this.isAlive = true;
	}
	
	public Animal (int numLegs, boolean hasFur, boolean hasTail, boolean isAlive) {
		this.numLegs = numLegs;
		this.hasFur = hasFur;
		this.hasTail = hasTail;
		this.isAlive = isAlive;
		
	}
	
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

	public static void main(String[] args) {

		

	}

}
