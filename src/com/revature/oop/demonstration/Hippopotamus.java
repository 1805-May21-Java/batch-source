package com.revature.oop.demonstration;

import com.revature.oop.intentionalexception.ExceptionHandler;

public class Hippopotamus extends Animal { // Inherits the states and behaviors of Animal

	public int averageWeight;
	public boolean hasFur;
	public boolean hasTail;
	public int numLegs;
	
	
	public static void main (String[] args) {
		Hippopotamus hippo = new Hippopotamus();
		Animal hippo2 = new Hippopotamus(); // Allows Hippopotamus() to be an instaceof Animal - Polymorphism
		// 
		hippo.setNumLegs(4); //Setting this number to below 4 will cause an error: See setNumLegs
		hippo2.setHasFur(false);
		hippo.setAverageWeight(3310);
		hippo.setHasTail(true);
		hippo.eat();
		
        
		System.out.println("The average weight of an adult Hippopotamus is " + hippo.averageWeight + "lbs");
		System.out.println("It has " + hippo.numLegs + " legs.");
		System.out.println("Hippos are covered in fur: " + hippo.hasFur);
		System.out.println("Hippos have a tail: " + hippo.hasTail);
		
		System.out.println((hippo instanceof Animal)); // Shows that hippo is an instance of Animal (Polymorphism)
		// Checks if hippo is an instanceof Animal - In this case, true. Proves polymorphism.
		
	}

	//Getters and Setters
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
	
	// Creates an override for the abstract method eat() in Animal.
	// Is an example of Dynamic Polymorphism
	@Override
	public void eat() {
		System.out.println("This animal eats mostly plants, unless you put your hand in it's mouth.");
	}
	
}
