package com.revature.main;

import com.revature.expections.NegativeAgeException;


/**
 * @author vannarahouth
 * In this class we can see Inheritance, Encapsulation, Polymorphism, and Abstraction processes.
 * Snake "inherited" from Reptile abstract class and define the implementation in Animal interface
 * 
 * We use private age to hide from other class and use getter and setter to retrieve the data
 * this process is called "Encapsulation" 
 * 
 *
 */
public class Snake extends Reptile implements Animal {

	private int age;
	@Override
	public int speed() {
		return 26;
	}

	public Snake() {
		super();
		this.type="Snake";
	}
	
	public Snake(int age) throws NegativeAgeException{
		super();
		this.type="Snake";
		this.age=age;
		if(this.age<0)
			throw new NegativeAgeException("The Age of The Snake Cannot Be Negative");
	}

	@Override
	public String animalName() {
	
		return this.type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
