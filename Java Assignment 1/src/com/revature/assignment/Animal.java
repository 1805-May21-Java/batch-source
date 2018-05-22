package com.revature.assignment;
//parent class
public abstract class Animal { //abstraction here
	protected String animalType;
	protected int height;
	protected String color;
	public void sound() {
		System.out.println("Animal makes sound");//abstract method
	}
	public Animal() { //default constructor
		super(); //the super helps in allowing the child classes to compile
	}
	public Animal(String animalType, int height, String color) {
		//extra constructor getting type, height, and color
		this.animalType = animalType;
		this.height = height;
		this.color = color;
	}
	//encapsulation deals with the behaviours of an animal
	public void run() {
		//implementation of run
	}
	public void hunt() {
		//implementation of hunt
	}
	public void swim() {
		//implementation of swim
	}
	
	//encapsulation with the sets and gets below
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
	