package com.revature.animals;

import com.revature.exceptions.DeadAnimalException;
//Inheritance - Inherits from the Animal class
public class Horse extends Animal {

	
	public Horse() {
		super();
		numLegs = 4;
	}
	//Polymorphism - Method Overriding - Creating a MakeNoise method for Horse
	@Override
	public void makeNoise() {
		try {
			if(!isLiving) throw new DeadAnimalException("Dead Horses make no noise");
		System.out.println("Neigh");

		} catch(DeadAnimalException dae) {
			dae.printStackTrace();
			System.out.println(dae.getMessage());
		}
	}
	public void beat() {
		super.beat();
		if(!isLiving) {
			System.out.println("Quit beatting a dead horse!");
		} else {
			System.out.println("Why would you harm this animal!");
		}
	}

}
