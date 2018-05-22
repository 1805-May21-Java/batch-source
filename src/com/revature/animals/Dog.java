package com.revature.animals;
import java.util.Random;

import com.revature.exception.*;

public class Dog extends Animal {

	// this blank space here is indicative of inheritance
	// because it would otherwise be a rewriting of the
	// parameters from the Animal class
	
	float furLength; // fur length in inches
	String furColor; // String storing the exact name for the dog's fur color
	
	public Dog() {
		super();
	}

	public Dog(int numLegs, int numTorpedos, float weight, float diameter, float maxSpeed, String name, float furLength, String furColor) {
		super(numLegs, numTorpedos, weight, diameter, maxSpeed, name);
		this.numLegs = 4;
		this.furLength = furLength;
		this.furColor = furColor;
	}

	public float getFurLength() {
		return furLength;
	}

	public void setFurLength(float furLength) throws NegativeLengthException {
		if(furLength <= 0)
			throw new NegativeLengthException();
		else
			this.furLength = furLength;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	// you know what's going down, but now with a hint of polymorphism
	// specifically, this is an overriding of the Animal class's
	// launchTorpedo method, now complete with dolphin sounds
	public void launchTorpedos(int amount) {
		if(this.numTorpedos <= 0) {
			System.out.println("\ngrrrrrrrr (" + this.name + " has no torpedos)");
		} else {
			Random rand = new Random();
			for(int i = 0; i < amount; i++) {
				if(this.numTorpedos <= 0) {
					System.out.println("\ngrrrrrrrrr (" + this.name + " has no torpedos)");
					break;
				}
				System.out.println("\nwoof woof! (" + this.name + " fires a torpedo)");
				int n = rand.nextInt(100);
				if(n < 44) // dogs are inaccurate
					System.out.println("awooooooo! (" + this.name + " hits and does a backflip)");
				else
					System.out.println("(" + this.name + " misses and whines a little)");
				this.numTorpedos--;
			}
		}
	}
}
