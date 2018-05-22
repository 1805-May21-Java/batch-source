package com.revature.animals;

import java.util.Random;

public class Dolphin extends Animal {

	// this blank space here is indicative of inheritance
	// because it would otherwise be a rewriting of the
	// parameters from the Animal class
	
	int depth; // underwater depth of the dolphin in feet
	
	public Dolphin() {
		super();
	}

	public Dolphin(int numLegs, int numTorpedos, float weight, float diameter, float maxSpeed, String name, int depth) {
		super(numLegs, numTorpedos, weight, diameter, maxSpeed, name);
		numLegs = 0;
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	// you know what's going down, but now with a hint of polymorphism
	// specifically, this is an overriding of the Animal class's
	// launchTorpedo method, now complete with dolphin sounds
	public void launchTorpedos(int amount) {
		if(this.numTorpedos <= 0) {
			System.out.println("\neee ee eeeeeeee (" + this.name + " has no torpedos)");
		} else {
			Random rand = new Random();
			for(int i = 0; i < amount; i++) {
				if(this.numTorpedos <= 0) {
					System.out.println("\neee ee eeeeeeee (" + this.name + " has no torpedos)");
					break;
				}
				System.out.println("\neeeeee eeeeeeee! (" + this.name + " fires a torpedo)");
				int n = rand.nextInt(100);
				if(n < 94) // dolphins are accurate
					System.out.println("eee! (" + this.name + " hits and does a backflip)");
				else
					System.out.println("eeee. (" + this.name + " misses)");
				this.numTorpedos--;
			}
		}
	}
}
