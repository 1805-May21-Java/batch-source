package com.revature.animals;
//Inheritance - Inherits from the Animal class

import com.revature.exceptions.DeadAnimalException;

public class Fish extends Animal {

	
	public Fish() {
		super();
		numLegs = 0;
	}


	//Polymorphism - Method Overriding - Creating a MakeNoise method for Fish
	@Override
	public void makeNoise() {
		try {
			if(!isLiving) throw new DeadAnimalException("The Fish is Dead");
			System.out.println("Fish do not make a noise");
		} catch (DeadAnimalException dae) {
			dae.printStackTrace();
			System.out.println(dae.getMessage());
		}
	}

}
