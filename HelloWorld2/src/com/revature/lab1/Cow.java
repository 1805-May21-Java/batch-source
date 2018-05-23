package com.revature.lab1;

public class Cow extends Animal {

	private final String name = "Cow";
	public Cow() {
		super();
	
	}


	@Override
	public void sound() {
		System.out.println("Moo!");
	}


	public String getName() {
		return name;
	}

}
