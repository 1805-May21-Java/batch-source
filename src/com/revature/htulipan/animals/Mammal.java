package com.revature.htulipan.animals;

// This class along with Fish demonstrate Polymorphism by both being child-classes of Animal.
public abstract class Mammal extends Animal {
	private boolean pregnant;
	
	public Mammal() {
		super();
	}

	public Mammal(int numberOfEyes, int age, boolean alive, boolean pregnant) {
		super(numberOfEyes, true, age, alive);
		this.pregnant = pregnant;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}
}
