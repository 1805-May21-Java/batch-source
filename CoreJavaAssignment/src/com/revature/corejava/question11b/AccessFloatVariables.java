package com.revature.corejava.question11b;

// Imports the class IHaveTwoFloats from question11a package
import com.revature.corejava.question11a.IHaveTwoFloats;

// This is the class that will access the float variables from IHaveTwoFloats
public class AccessFloatVariables {

	// Initializes two float variables both to 0f
	private float one=0f;
	private float two=0f;
	
	// Constructor that calls to the super class
	public AccessFloatVariables() {
		super();
	}

	// Getter to return the value of the one variable
	public float getOne() {
		return one;
	}

	//Getter to return the value of the two variable
	public float getTwo() {
		return two;
	}
	
	// Method that sets the values of one and two to the values of one and two from the IHaveTwoFloats class
	public void accessFloats() {
		IHaveTwoFloats ihtf=new IHaveTwoFloats();
		one=ihtf.getOne();
		two=ihtf.getTwo();
	}

}
