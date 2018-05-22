package com.revature.oop;

public class Animal {
	
	protected int numLegs;
	public String name;
	protected boolean canFly;
	
	public Animal() {
		super();
	}
	
	public Animal(String name, int numLegs, boolean canFly) {
		this.name = name;
		this.numLegs = numLegs;
		this.canFly = canFly;
	}
	
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	public void predatorAttack() {
		this.numLegs--;
	}

	
	

}
