package com.revature.corejava.question11b;

public class AccessFloatsDriver {

	public static void main(String[] args) {
		// Create new instance of AccessFloatVariables
		AccessFloatVariables afv=new AccessFloatVariables();
		
		// Check that the variables one and two are currently not set to the values of the floats in IHaveTwoFloats
		System.out.println("Before we access the variables in IHaveTwoFloats class");
		System.out.println("afv one variable is "+afv.getOne());
		System.out.println("afv two variable is "+afv.getTwo());
		
		// Call the accessFloats method to set afv's variables to the variables from IHaveTwoFloats
		afv.accessFloats();
		
		// Provide space
		System.out.println();
		
		// Check that the variables one and two are now set to tthe values of the floats in IHaveTwoFloats
		System.out.println("After we access the variables in IHaveTwoFloats class");
		System.out.println("afv one variable is now "+afv.getOne());
		System.out.println("afv two variable is now "+afv.getTwo());
		

	}

}
