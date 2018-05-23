package com.revature.lab1;

public class Bee extends Animal {

	private final String name = "Bee";

	public Bee() {
		super();
	}

	public void sound() {
		System.out.println("Buzz!");
	}

	public String getName() {
		return name;
	}
}
