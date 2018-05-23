package com.revature.htulipan.animals;

import com.revature.htulipan.animalexceptions.FishOutOfWaterException;

// This class along with Mammal demonstrate Polymorphism by both being child-classes of Animal.
public abstract class Fish extends Animal {
	private float depth;

	public Fish() {
		super();
	}

	public Fish(int numberOfEyes, int age, boolean alive, float depth) {
		super(numberOfEyes, false, age, alive);
		this.depth = depth;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) throws FishOutOfWaterException {
		if (depth < 0) {
			throw new FishOutOfWaterException();
		} else {
			this.depth = depth;
		}
	}
	
	public void swimUp(float amount) throws FishOutOfWaterException {
		if (this.depth - amount < 0.0) {
			setDepth(0.0f);
			throw new FishOutOfWaterException();
		} else {
			this.depth -= amount;
		}
	}
	
	public void swimDown(float amount) {
		this.depth += amount;
	}
}
