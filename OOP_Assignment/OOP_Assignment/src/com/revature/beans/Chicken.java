package com.revature.beans;

import com.revature.abstraction.Bird;

public class Chicken extends Bird { // implementing inheritance. Chicken will be able to use the feedYoung method

	public Chicken() {
		super();
	}

	public Chicken(boolean canFly) {
		super(canFly);
	}

	// overriding the speak method from the parent class is an example of polymorphism
	@Override
	public void speak() {
		System.out.println("Chicken says cluck.");
	}

}
