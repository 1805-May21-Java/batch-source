package com.revature.OOps;

public class Animal {
	// example of encapsulation, using private as access-modifiers.
	private String color;
	private int age;
	private String name;
	private int noOfLegs ;
	// constructor overloading
	public Animal() { // default constructor for default values to the object
		super();
		
	}
	public Animal(String color, int age, String name, int noOfLegs) { // parameterzied constructor
		super();
		this.color = color;
		this.age = age;
		this.name = name;
		this.noOfLegs = noOfLegs;
	}
	// generating getter and setter method in order to modify the private data members
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfLegs() {
		return noOfLegs;
	}
	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}
	// method overloading
	public void move() {
    System.out.println("animal is moving ...." );
}
	public void move(int noOfLegs) {
		System.out.println("animal is moveing  with " + noOfLegs  + " legs ");
	}
	public void eat() {
		System.out.println("animal is eating .......");
	}
}