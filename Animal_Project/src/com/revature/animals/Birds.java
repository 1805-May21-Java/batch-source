package com.revature.animals;

//Abstract class for mammals, inherits from Animal
public abstract class Birds extends Animals {

	boolean canFly;
	float wingSpan;
	
	public Birds() {
		super();
	}
	
	public Birds(boolean canFly, float wingSpan) {
		this.canFly = canFly;
		this.wingSpan = wingSpan;
	}

}
