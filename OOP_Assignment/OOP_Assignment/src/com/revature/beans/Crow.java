package com.revature.beans;

import com.revature.abstraction.Bird;

public class Crow extends Bird { // implementing inheritance. Crow will be able to use the feedYoung method

	public Crow() {
		super();
	}

	public Crow(boolean canFly) {
		super(canFly);
	}

	// overriding the speak method from the parent class is an example of polymorphism
	@Override
	public void speak() {
		System.out.println("Crow says caw.");
	}

	
}