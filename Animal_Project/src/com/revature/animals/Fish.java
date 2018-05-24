package com.revature.animals;

//Abstract class for mammals, inherits from Animal
public abstract class Fish extends Animals {

	float swimSpeed;
	
	
	public Fish() {
		super();
	}
	public Fish(float swimSpeed) {
		this.swimSpeed = swimSpeed;
	}
	

}
