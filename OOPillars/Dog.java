package com.revature.OOPillars;

import com.revature.exceptions.NegativeAgeException;

public class Dog extends Mammal {
	private String breed;
	private boolean isDomesticated;
	private int age;
	
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dog(boolean liveBirth) {
		super(liveBirth);
		// TODO Auto-generated constructor stub
	}
	
	public Dog(int numOfLimbs, int numOfEyes, boolean isAlive, char gender) {
		super(numOfLimbs, numOfEyes, isAlive, gender);
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String breed, boolean isDomesticated) {
		super();
		this.breed = breed;
		this.isDomesticated = isDomesticated;
	}
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isDomesticated() {
		return isDomesticated;
	}

	public void setDomesticated(boolean isDomesticated) {
		this.isDomesticated = isDomesticated;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
	
		if (age < 0) {
				try 
					{
						throw new NegativeAgeException("An animal may not have a negative age");
					} catch (NegativeAgeException e) {
						e.printStackTrace();
					}
					
			}

	}
	
	public void move(int units) {
		System.out.println("The dog has run " + units + " units.") ;
	}

}
