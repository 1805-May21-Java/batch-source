package com.revature.oopdemo;

public class AnimalDriver {

	public static void main(String[] args) {
		Cat scratchy = new Cat("Scratchy", 4);
		Horse winnie = new Horse("Winnie", 6, 30);
		// Even though scratchy is a Cat and winnie is a Horse, they can be passed into printAnimalDetails
		// which accepts an Animal
		printAnimalDetails(scratchy);
		printAnimalDetails(winnie);
		
		System.out.println("Winnie's speed is: " + winnie.getCurrentSpeed());
		winnie.speedUp(5);
		System.out.println("Winnie's speed is: " + winnie.getCurrentSpeed());
		

	}
	
	public static void printAnimalDetails(Animal animal) {
		System.out.println("Name: " + animal.getName());
		System.out.println("Age: " + animal.getAge());
		System.out.println("Is friendly? " + animal.getIsFriendly());	
		System.out.println();
	}

}
