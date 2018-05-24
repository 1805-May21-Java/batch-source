package com.revature.htulipan.animals;

// Starfish demonstrates Inheritance by inheriting the attributes of Fish (depth) and Animal
// (numberOfEyes, age, alive, terrestrial) as well as their methods (getters, setters, swimUp, swimDown).
public class Starfish extends Fish {
	
	public Starfish() {
		super();
	}

	public Starfish(int numberOfEyes, int age, boolean alive, float depth) {
		super(numberOfEyes, age, alive, depth);
	}

	// Starfish and Dog demonstrate Polymorphism by implementing different versions of the makeNoise() method
	// which is inherited from their common ancestor class, Animal.
	public void makeNoise() {
		System.out.println("..........");
	}
}
