package com.revature.beans;

import com.revature.abstraction.Mammal;

public class Dog extends Mammal { // implementing inheritance

	public Dog() {
		super();
	}
	
	// overriding the speak method from the parent class is an example of polymorphism
	@Override
	public void speak() {
		System.out.println("Dog says bark.");
	}

}
