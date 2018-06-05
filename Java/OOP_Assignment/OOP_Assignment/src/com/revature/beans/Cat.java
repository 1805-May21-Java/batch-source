package com.revature.beans;

import com.revature.abstraction.Mammal;

public class Cat extends Mammal { // implementing inheritance

	public Cat() {
		super();
	}
	
	// overriding the speak method from the parent class is an example of polymorphism
	@Override
	public void speak() {
		System.out.println("Cat says meow.");
	}

}
