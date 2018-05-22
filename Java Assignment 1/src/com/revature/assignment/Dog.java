package com.revature.assignment;
//Dog, Cat, and Duck do inheritance, as they inherit from Animal
public class Dog extends Animal{ //child of Animal
	@Override //polymorphism
	public void sound() { // concrete method with a body
		System.out.println("Woof");
	}
	public static void main(String args[]) {
		Animal obj = new Dog(); //creating new Dog from Animal
		obj.sound();
	}
}
