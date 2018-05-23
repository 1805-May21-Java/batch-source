package com.revature.lab1;

public class Goat extends Animal {

	private final String name = "Goat";

	public Goat() {
		super();
	}

	public void sound() {
		System.out.println("Bleat!");
	}

	public String getName() {
		return name;
	}
	
}
