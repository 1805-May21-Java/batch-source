package com.revature.oopdemo;

// This is an example of Inheritance
// The cat gets all of the properties and methods of the Animal
// class because it extends it. In the constructors it calls
// the methods defined in the parent class.

public class Cat extends Animal {
	private boolean likesCatnip;

	public Cat (String name, int age, boolean isFriendly) {
		super(name, age, isFriendly);
		setHappyNoise("purrrr.");
		setAngryNoise("mrow!");
		setLikesCatnip(true);
	}
	
	public Cat(String name, int age) {
		super(name, age);
		setHappyNoise("purrrr.");
		setAngryNoise("mrow!");
		setLikesCatnip(true);
	}

	
	@Override
	void makeNoise() {
		System.out.println("meow.");
	}
	
	// Data Encapsulation
	// This subclass has a private properties likes catnip that can only be accessed through
	// public getter and setter methods.
	
	public void setLikesCatnip(boolean likesCatnip) {
		this.likesCatnip = likesCatnip;
	}
	
	public boolean getLikesCatnip() {
		return likesCatnip;
	}		

}
