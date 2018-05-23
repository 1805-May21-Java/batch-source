package com.revature.lab1;

public class Horse extends Animal {

	private final String name = "Horse";

	
	public Horse() {
		super();
	}
	
	public void sound() {
		System.out.println("Neigh!");
	}

	public String getName() {
		return name;
	}
}
