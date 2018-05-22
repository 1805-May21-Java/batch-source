package com.revature.abstraction;

public abstract class Mammal extends Animal { // implementing inheritance

	// overriding the feedYoung method from the parent class is an example of polymorphism
	@Override
	public void feedYoung() {
		System.out.println("Gives milk");
	}

}
