package com.revature.abstraction;

import com.revature.exceptions.NegativeAgeException;

// the Animal class implementing the MakesSound interface is an example of abstraction because
// outside users do not need to know how the animals make sound, just that they can.
public abstract class Animal implements MakesSound {
	
	// having the age variable be private along with the public setter and getter
	// is an example of encapsulation.
	private int age;
	public abstract void feedYoung();
	public abstract void speak();
	
	public int getAge() {
		return age;
	}
	
	// uses the NegativeAgeException to make sure the age is a valid value
	public void setAge(int age) {
		if(age < 0) {
			try {
				throw new NegativeAgeException("Cannot have a negative value for age.");
			} catch (NegativeAgeException e) {
				e.printStackTrace();
			}
		}
		this.age = age;
	}
}
