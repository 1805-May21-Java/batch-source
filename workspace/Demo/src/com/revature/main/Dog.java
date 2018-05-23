package com.revature.main;

import com.revature.expections.NegativeAgeException;


/**
 * @author vannarahouth
 * In this class we can see Inheritance, Encapsulation, Polymorphism, and Abstraction processes.
 * Dog "inherited" from Mammal abstract class and define the implementation in Animal interface
 * 
 * We use private age to hide from other class and use getter and setter to retrieve the data
 * this process is called "Encapsulation" 
 * 
 *
 */


public class Dog extends Mammal implements Animal{

	private int age;	
	public Dog() {
		super();
		this.type="Dog";
	}
	
	
	public Dog(int age) throws NegativeAgeException {
		super();
		this.type="Dog";
		this.age=age;
		if(this.age<0)
		{
			throw new NegativeAgeException("The Age of the Dog Cannot Be Negative");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void makeNoise() {
		System.out.println("Woaf woaf");
	}

	
	@Override
	public int speed() {
		return 40;
	}


	@Override
	public String animalName() {
		return this.type;
	}
	
}
