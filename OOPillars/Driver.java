package com.revature.OOPillars;

public class Driver {

	public static void main(String[] args) {
		Animal dog = new Dog(4, 2, true, 'M');
		Dog newDog = new Dog(3, 2, true, 'F'); 
		// newDog.setAge(-4); <- exception
		Snake snake = new Snake(0, 2, true, 'F');
		
		// dog.setBreed("Pomeranian"); <- doesn't work since no breed data member in Animal
		newDog.setBreed("Rottweiler");
		snake.setBreed("Cobra");
		snake.setVenomous(true); 
		
		System.out.println("Welcome to our animal farm!");
		System.out.println("We have two dogs and a snake!");
		System.out.println("Our dog has " + dog.getNumOfLimbs() + " limbs " + dog.getNumOfEyes() + " eyes and is a " + dog.getGender() + " dog.");
		System.out.println("Our new dog has " + newDog.getNumOfLimbs() + " limbs " + newDog.getNumOfEyes() + " eyes and is a " + newDog.getGender() + " dog.");
		System.out.println("Our snake is a " + snake.getBreed() + ".");
		if (snake.isVenomous() == true) {
			System.out.println("WARNING! This snake is HIGHLY DANGEROUS and VENOMOUS!!");
		}
		else {
			System.out.println("This snake is non-venomous.");
		}
		
		dog.move(20);
		newDog.move(5);
		snake.move(10);
	}
	

}
