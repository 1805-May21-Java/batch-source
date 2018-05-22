package com.revature.animals;

//Abstract class for mammals, inherits from Animal
public abstract class Mammals extends Animals {
	
	private int gestationTime;
	private float diameterOfHair;

	public Mammals() {
		super();
	}
	
	public Mammals(int gestationTime,float diameterOfHair ) {
		super();
		this.gestationTime = gestationTime;
		this.diameterOfHair = diameterOfHair;
	}
	

}
