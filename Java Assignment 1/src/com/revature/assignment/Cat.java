package com.revature.assignment;

public class Cat extends Animal{ // child of Animal
	@Override //polymorphism
	public void sound() { // concrete method with body
		System.out.println("Meow"); 
	}
	public static void main(String args[]) {
		Animal obj = new Cat(); //creating new Cat from Animal
		obj.sound();
	}
}
