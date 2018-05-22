package com.revature.abstraction;

public abstract class Bird extends Animal { // implementing inheritance

	// having the canFly variable be private along with the public setter and getter
	// is an example of encapsulation.
	private boolean canFly;

	public Bird() {
		super();
	}

	public Bird(boolean canFly) {
		super();
		this.canFly = canFly;
	}

	public boolean getCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	// overriding the feedYoung method from the parent class is an example of polymorphism
	@Override
	public void feedYoung() {
		System.out.println("Regurgitates into baby's mouth");
	}

}
