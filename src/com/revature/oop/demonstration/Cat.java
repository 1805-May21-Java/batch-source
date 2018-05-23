package com.revature.oop.demonstration;

import com.revature.intentionalexception.ExceptionHandler;

public class Cat extends Animal { // Inherits the states and behaviors of Animal
	
	public int averageWeight;
	public boolean hasFur;
	public boolean hasTail;
	private int numLegs; // Example of encapsulation - int numLegs is only available within the same class and is only accessible through the setter.
	
	
	public static void main (String[] args) {
		Cat cat1 = new Cat();
		cat1.setNumLegs(2); //Setting this number to below 4 will cause an error: See setNumLegs
		cat1.setHasFur(true);
		cat1.setAverageWeight(15);
		cat1.setHasTail(true);
		cat1.eat();
		
		System.out.println("The average weight of an adult Cat is " + cat1.averageWeight + "lbs");
		System.out.println("It has " + cat1.numLegs + " legs.");
		System.out.println("Cats are covered in fur: " + cat1.hasFur);
		System.out.println("Cats have a tail: " + cat1.hasTail);
		
	}

	// Getters and Setters
	public int getAverageWeight() {
		return averageWeight;
	}


	public void setAverageWeight(int averageWeight) {
		this.averageWeight = averageWeight;
	}


	public boolean isHasFur() {
		return hasFur;
	}


	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}


	public boolean isHasTail() {
		return hasTail;
	}


	public void setHasTail(boolean hasTail) {
		this.hasTail = hasTail;
	}


	public int getNumLegs() {
		return numLegs;
	}


	public void setNumLegs(int numLegs) {
		if (numLegs < 4) { // Checks if the number of legs an animal has is less than 4
			try { // If the number of legs is less than 4 this block runs.
			throw new ExceptionHandler("You should probably see the vet, your animal is missing a leg!");
			}catch (ExceptionHandler e) {
				e.printStackTrace();
			}
		}
		this.numLegs = numLegs;
	}
	// End Getters and Setters
	
	// Creates an override for the abstract method in Animal.
	// Is an example of Dynamic Polymorphism
	@Override
	public void eat() {
		System.out.println("Cats eat both meat and plants");
	}
	
}
