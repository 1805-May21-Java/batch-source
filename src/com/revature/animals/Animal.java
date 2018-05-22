package com.revature.animals;
import com.revature.exception.*;
import java.util.Random;

public class Animal {

	protected int numLegs;		// number of legs
	protected int numTorpedos;	// number of torpedos
	protected float weight;		// weight of the animal, in pounds
	protected float diameter;	// longest distance of space occupied by the animal, in feet
	protected float maxSpeed;	// maximum attainable speed by the animal, in miles per hour
	protected String name;		// name of the animal
	
	// empty constructor
	public Animal() {
		super();
	}

	// standard constructor
	public Animal(int numLegs, int numTorpedos, float weight, float diameter, float maxSpeed, String name) {
		super();
		this.numLegs = numLegs;
		this.numTorpedos = numTorpedos;
		this.weight = weight;
		this.diameter = diameter;
		this.maxSpeed = maxSpeed;
		this.name = name;
	}

	// getters and setters to exemplify encapsulation
	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}

	public int getNumTorpedos() {
		return numTorpedos;
	}

	public void setNumTorpedos(int numTorpedos) {
		this.numTorpedos = numTorpedos;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getDiameter() {
		return diameter;
	}

	// Here's my exception handling!
	public void setDiameter(float diameter) throws NegativeLengthException {
		if(diameter <= 0)
			throw new NegativeLengthException();
		else
			this.diameter = diameter;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// you know what's going down
	public void launchTorpedos(int amount) {
		// but you don't need to read anything in this function implementation
		// to know how it works, a solid example of abstraction
		if(this.numTorpedos <= 0) {
			System.out.println("Out of torpedos :(");
		} else {
			System.out.println("Firing torpedos!");
			Random rand = new Random();
			for(int i = 0; i < amount; i++) {
				if(this.numTorpedos <= 0) {
					System.out.println("Out of torpedos :(");
					break;
				}
				int n = rand.nextInt(100);
				if(n < 73)
					System.out.println("Hit!");
				else
					System.out.println("Miss.");
				this.numTorpedos--;
			}
		}
	}
}
