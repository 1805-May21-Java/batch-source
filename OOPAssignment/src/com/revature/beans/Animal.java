package com.revature.beans;

public class Animal {
	
// Attributes that all animals have
	protected int weight;
	protected int height;
	protected int age;
	protected short name;

	public Animal() {
		super();
	}

	public Animal(int weight, int height, int age, short name){
		super();
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.name = name;
	}

	
//The following getters and setters are an example of Encapsulation. The variables are private
//but the public methods here have access
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public short getName() {
		return name;
	}

	public void setName(short name) {
		this.name = name;
	}
	
	public void weightGain(int increment) {
		this.weight += increment;
		System.out.println("Animal has gained weight by " + increment);
		System.out.println("Animal's current weight is " + this.weight);
	}
	
	public void weightLoss(int decrement) {
		this.weight -= decrement;
		System.out.println("Animal has lost weight by " + decrement);
		System.out.println("Animal's current weight is " + this.weight);
	}

}
