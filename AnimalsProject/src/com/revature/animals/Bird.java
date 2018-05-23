package com.revature.animals;

public class Bird extends Animal{

//	Constructor to allow for a generic way to initalize a new Bird
	public Bird() {
		super();
	}

//	Overloading the constuctor to allow for a more detailed way to initalize a new Bird
	public Bird(String food, String sound, int numOfLegs) {
		this.food=food;
		this.numOfLegs=numOfLegs;
		this.sound=sound;
	}

//	Overriding the abstract moveAnimal method from the Animal class so as to add behavior
	@Override
	public void moveAnimal() {
		System.out.println("The bird is flying.");
	}
	
}
