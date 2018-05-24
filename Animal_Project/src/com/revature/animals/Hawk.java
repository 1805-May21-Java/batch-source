package com.revature.animals;

//Hawk inherits from Birds
public class Hawk extends Birds{
	
	public Hawk() {
		super();
	}
	public Hawk(float wingSpan) {
		//Hawks can fly, so that can just be true
		super(true,wingSpan);
	}

	@Override
	void reproduce() {
		super.reproduce();
		Hawk hawk = new Hawk();
	}
	
}
