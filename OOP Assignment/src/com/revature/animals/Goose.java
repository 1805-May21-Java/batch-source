package com.revature.animals;

//Inheritance - Inherits from the birds class, which inherits from Animal class
public class Goose extends Birds{

	@Override
	public void makeNoise() {
		System.out.println("Honk");
	}
	public void makeAngryNoise() {
		System.out.println("Angry Honking");
	}
	
}
