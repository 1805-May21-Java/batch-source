package com.revature.animals;

import com.revature.interfaces.ISpeaks;
import com.revature.exceptions.*;

public abstract class Animal implements ISpeaks{
	
	/*
	 * Since these variables are either set to protected or private, they cannot
	 * be accessed outside of this class and subclasses of this class. This is 
	 * Encapsulation, the hiding of data by wrapping variables. These can only be
	 * accessed by outside classes iff the getters and setters, which are defined
	 * below, are used.
	 * 
	 * For an example of why this is helpful see the setAge(int) method
	 */
	protected int numLimbs;
	protected int speed;
	private int maxSpeed;
	protected int age;
	protected String favoriteFood;
	
	//Constructors
	public Animal() {
		super();
		this.favoriteFood = "";
		this.maxSpeed = 100;
	}	
	public Animal(int numLimbs, int speed, int maxSpeed, int age, String favoriteFood) {
		super();
		this.numLimbs = numLimbs;
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.age = age;
		this.favoriteFood = favoriteFood;
	}



	public void speedUp(int speed) {
		this.speed += speed;
		if (this.speed > this.maxSpeed) {
			this.speed = this.maxSpeed;
		}
	}
	
	public void slowDown(int speed) {
		this.speed -= speed;
		if (this.speed < 0) {
			this.speed = 0;
		}
	}
	
	public void eat() {
		if (this.favoriteFood.equals("")) {
			System.out.println("They don't know what to eat.");
		} else {
			System.out.println("The animal eats " + this.favoriteFood + ". What a delight! It's their favorite.");
		}
	}
	
	

	//Generated Getters and Setters
	public int getNumLimbs() {
		return numLimbs;
	}

	public void setNumLimbs(int numLimbs) {
		this.numLimbs = numLimbs;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAge() {
		return age;
	}

	/* 
	 * By hiding the age of the animal from outside classes we don't run the risk of
	 * setting the value to a negative number. This is because we can validate the 
	 * value put into the setAge(int) method before setting that value into this.age.
	 * We use a custom Exception here to give more details on what went wrong. It also
	 * prints a stack trace so that you can find the exception in your code.
	 */
	public void setAge(int age) {
		if(age < 0) {
			try {
				throw new UnbornException("This animal cannot exist with a negative age!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.age = age;
		}
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	
	
	
	
}
