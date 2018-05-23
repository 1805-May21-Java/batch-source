package com.revature.main;


/**
 * @author vannarahouth
 * The Reptile class is use to implements Animal interface
 * In this case Reptile class will implement makeNoise() method from Animal
 * this process is also called Abstraction. 
 *
 *In this case we also use encapsulation to wrap variables and behavior (makeNoise) into a single unit.
 * We use access modifier and getter and setter to achieve this. 
 */
public abstract class Reptile implements Animal {

	protected String type = "Reptile";
	@Override
	public void makeNoise() {
		System.out.println("Shii shii");
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
