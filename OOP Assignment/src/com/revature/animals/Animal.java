package com.revature.animals;

import com.revature.exceptions.DeadAnimalException;
//Abstraction - using an abstract class to have variables (with getters and setters) and defaulted
//methods, along with a makeNoise method that must be implemented by the sub-classes
public abstract class Animal {
	int height, weight, numLegs, pain;
	int xPosition, yPosition;
	boolean isLiving;
	String name;
	
	
	//Getter and Setter methods for above variables - Encapsulation
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public boolean isLiving() {
		return isLiving;
	}
	public void setLiving(boolean isLiving) {
		this.isLiving = isLiving;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPain() {
		return pain;
	}
	public void setPain(int pain) {
		this.pain = pain;
	}
	
	//Default Constructor
	public Animal() {
		super();
		isLiving = true;
	}
	//Constructor from fields
	public Animal(int height, int weight, int numLegs, int xPosition, int yPosition) {
		super();
		this.height = height;
		this.weight = weight;
		this.numLegs = numLegs;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.isLiving = true;
	}
	public abstract void makeNoise();
	public void moveXPosition(int xIncrement) {
		try {
			if(!isLiving) throw new DeadAnimalException("Dead Animals can't move");
		this.xPosition += xIncrement;
		} catch(DeadAnimalException dae){
			dae.printStackTrace();
			System.out.println(dae.getMessage());
		}
	}
	public void moveYPosition(int yIncrement) {
		try {
			if(!isLiving) throw new DeadAnimalException("Dead Animals can't move");
		this.yPosition += yIncrement;
		} catch(DeadAnimalException dae){
			dae.printStackTrace();
			System.out.println(dae.getMessage());
		}
	}
	public void move(int xIncrement, int yIncrement) {
		try {
			if(!isLiving) throw new DeadAnimalException("Dead Animals can't move");
		this.xPosition += xIncrement;
		this.yPosition += yIncrement;
		} catch(DeadAnimalException dae){
			dae.printStackTrace();
			System.out.println(dae.getMessage());
		}
	}
	public void killAnimal() {
		this.isLiving = false;
	}
	public void beat() {
		pain++;
		if(pain>2) {
			this.killAnimal();
			System.out.println("You killed it!!!");
		}
	}
	

}
