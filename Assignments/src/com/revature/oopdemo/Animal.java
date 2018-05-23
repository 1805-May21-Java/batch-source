package com.revature.oopdemo;

public abstract class Animal {
	
	protected String name;
	protected int age;
	
	protected String happyNoise;
	protected String angryNoise;
	protected String happyAction;
	protected String angryAction;
	
	protected boolean isFriendly;
	
	
	// This is an example of Abstraction
	// Anything that encounters an Animal class knows that any Animal can makeNoise, but 
	// there are no details to how the noise is made. In the subclasses, the makeNoise
	// methods are implemented differently based on the class.
	
	abstract void makeNoise();
	
	
	// The following is an example of Polymorphism
	// There are two constructors with the same name. The first one accepts three
	// parameters and the second only accepts two. This is known as method
	// overloading.
	public Animal(String name, int age, boolean isFriendly) {
		
		setName(name);
		setAge(age);
		setIsFriendly(isFriendly);
		
	}
	
	public Animal(String name, int age) {
		
		setName(name);
		setAge(age);
		setIsFriendly(false);
		
	}
	
	// The next 4 methods are an example of Encapsulation.
	// In order for classes that are not subclasses of Animal to have access to 
	// To the name and age of the animal, or to view the noise an animal makes
	// They have to use getter and setter methods, which can validate the data.
	// The setters for name and age does data validation in order to ensure the
	// validity of the data being entered
	public String getName() {
		return name;
	}
	
	// checks to make sure the name is not an empty/whitespace string
	public void setName(String name) {
		if(name.trim().length() == 0) {
			System.out.println("The name cannot be empty");
			return;
		}
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	// checks to make sure the age is not less than 0
	public void setAge(int age) {
		if(age < 0) {
			System.out.println(this.name + "'s age cannot be less than 0");
			this.age = 0;
			return;
		}
		this.age = age;
	}
	
	public boolean getIsFriendly() {
		return isFriendly;
	}
	
	public void setIsFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}
	
	public void makeHappyNoise() {
		System.out.println(happyNoise);
	}
	
	public void setHappyNoise(String happyNoise) {
		this.happyNoise = happyNoise;
	}
	
	public void makeAngryNoise() {
		System.out.println(angryNoise);
	}
	
	public void setAngryNoise(String angryNoise) {
		this.angryNoise = angryNoise;
	}
	
	public void pet() {
		if(isFriendly) {
			makeHappyNoise();
		} else {
			makeAngryNoise();
		}
	}
	

}
