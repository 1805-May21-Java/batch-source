package com.revature.assignment;

public class Duck extends Animal{ // child of Animal
	@Override //polymorphism
	public void sound() { //concrete method with a body
		System.out.println("Quack");
	}
	public static void main(String args[]) {
		Animal obj = new Duck(); //creating new Duck from Animal
		obj.sound();
	}
}
