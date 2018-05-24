package com.revature.animals;

//Catfish inherits from Fish
public class Catfish extends Fish {
	
	 public Catfish() {
		super();
	}
	 public Catfish(float swimSpeed) {
		 super(swimSpeed);
	 }
	 

	 //
	@Override
	void reproduce() {
		super.reproduce();
		Catfish fish = new Catfish();			
	}
	
}
