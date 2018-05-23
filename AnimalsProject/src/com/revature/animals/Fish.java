package com.revature.animals;

public class Fish extends Animal{

//	Constructor to allow for a generic way to initalize a new Fish
	public Fish() {
		super();
		food="Worms";
		sound="blup blup";
		numOfLegs=0;
	}

//	Overloading the constuctor to allow for a more detailed way to initalize a new Fish
	public Fish(String food, String sound, int numOfLegs) {
		this.food=food;
		this.sound=sound;
		this.numOfLegs=numOfLegs;
	}
	
//	Overriding the abstract moveAnimal method from the Animal class so as to add behavior	
	@Override
	public void moveAnimal() {
		System.out.println("The fish is swimming.");
	}
}
