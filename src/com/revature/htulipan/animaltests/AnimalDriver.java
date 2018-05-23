package com.revature.htulipan.animaltests;

import com.revature.htulipan.animalexceptions.FishOutOfWaterException;
import com.revature.htulipan.animalexceptions.GoodDogException;
import com.revature.htulipan.animals.Animal;
import com.revature.htulipan.animals.Dog;
import com.revature.htulipan.animals.Starfish;

public class AnimalDriver {

	public static void main(String[] args) {
		Animal creature1 = new Dog();
		Animal creature2 = new Starfish();
		
		// The Animal class demonstrates Abstraction by leaving the implementation of makeNoise() to
		// concrete-classes Dog and Starfish. In this way, the two instances of the Animal class
		// can use the makeNoise() method (and also have different results) without that method
		// being defined in the Animal class.
		System.out.println("Animal 1 says:");
		creature1.makeNoise();
		System.out.println("Animal 2 says:");
		creature2.makeNoise();
		
		System.out.println();
		
		System.out.println("Creating a new Starfish.");
		Starfish creature3 = new Starfish();
		System.out.println("Setting starfish depth to 30 ft");
		try {
			creature3.setDepth(30);
			System.out.println("Starfish depth at: " + creature3.getDepth());
			System.out.println("Moving starfish up 50 ft.");
			creature3.swimUp(50);
		} catch (FishOutOfWaterException fwe) {
			System.out.println("Failed:");
			System.out.println(fwe.getMessage());
		}
		
		System.out.println();
		
		System.out.println("Creating a new Dog.");
		Dog creature4 = new Dog();
		System.out.println("Attempting to set Dog status to \"Bad Dog\"");
		try {
			creature4.setGoodDog(false);
		} catch (GoodDogException gde) {
			System.out.println("Failed:");
			System.out.println(gde.getMessage());
		}
		
	}

}
