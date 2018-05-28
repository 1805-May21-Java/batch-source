package com.revature.corejava.question6;

public class EvenDriver {

	public static void main(String[] args) {
		
		// Creates a new DetermineEven object with a number value of 20
		DetermineEven de=new DetermineEven(20);
		
		// Checks to see if 20 is even, should print true
		System.out.println("Test if 20 is even");
		System.out.println(de.checkEven());
		System.out.println();
		
		// Changes the value of number to 55
		de.setNumber(55);
		
		// Checks to see if 55 is even, should return false
		System.out.println("Test if 55 is even");
		System.out.println(de.checkEven());

	}

}
