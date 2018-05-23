package com.revature.oop.demonstration;

import com.revature.intentionalexception.ExceptionHandler;

public class Dog extends Animal { // Inherits the states and behaviors of Animal

	public int averageWeight;
	public boolean hasFur;
	public boolean hasTail;
	public int numLegs;
	
	
	public static void main (String[] args) {
		Dog dog1 = new Dog();
		dog1.setNumLegs(4); //Setting this number to below 4 will cause an error: See setNumLegs
		dog1.setHasFur(true);
		dog1.setAverageWeight(50);
		dog1.setHasTail(true);
		dog1.eat();
		
		System.out.println("The average weight of an Dog is " + dog1.averageWeight + "lbs");
		System.out.println("It has " + dog1.numLegs + " legs.");
		System.out.println("Dogs are covered in fur: " + dog1.hasFur);
		System.out.println("Dogs have a tail: " + dog1.hasTail);
		
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
		if (numLegs < 4) {  // Checks if the number of legs an animal has is less than 4
			try { // If the number of legs is less than 4 this block runs.
				throw new ExceptionHandler("You should probably see the vet, your animal is missing a leg!");
			} catch (ExceptionHandler e) {
				e.printStackTrace();
			}
		}
		this.numLegs = numLegs;
	}
	// End Getters and Setters
	
	
	// Show what happens if you don't override the eat() method in Animal.
	/*@Override
	public void eat() {
		System.out.println("Cats. Dogs eat cats. Don't tell Avery.");
	}*/ 
}
