package com.revature.htulipan.animals;

import com.revature.htulipan.animalexceptions.GoodDogException;

//Dog demonstrates Inheritance by inheriting the attributes of Mammal (pregnant) and Animal
//(numberOfEyes, age, alive, terrestrial) as well as their methods (getters, setters).
public class Dog extends Mammal {
	private boolean goodDog = true;
	
	public Dog() {
		super();
	}
		
	public Dog(int numberOfEyes, int age, boolean alive, boolean pregnant) {
		super(numberOfEyes, age, alive, pregnant);
	}

	// Dog and Starfish demonstrate Polymorphism by implementing different versions of the makeNoise() method
	// which is inherited from their common ancestor class, Animal.
	public void makeNoise() {
		System.out.println("Woof!");
	}
	
	public boolean isGoodDog() {
		return this.goodDog;
	}
	
	public void setGoodDog(boolean goodDog) throws GoodDogException {
		if (!goodDog) {
			throw new GoodDogException();
		} else {
			this.goodDog = goodDog;
		}
	}
}
