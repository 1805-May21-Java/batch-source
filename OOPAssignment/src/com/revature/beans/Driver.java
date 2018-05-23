package com.revature.beans;

public class Driver {

	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		d1.weightLoss(5);
		
//Here is an example of Polymorphism using method overriding. An object of Animal is created with
//reference to Horse.
		Animal a1 = new Horse();
		
//This is also an example of Abstraction. Hiding the details of how it is completed but
//completing a given task
		a1.weightLoss(10);

	}

}
