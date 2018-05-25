package com.revature.algorithms;

public class EvenNumberCheck {

	public EvenNumberCheck() {
		super();
	}

	// checks whether or not a number is even or odd by looking at the result of the number mod 2
	// prints the result
	public static void checkIfEven(int n) {
		int intDiv = n / 2;
		double doubleDiv = n / 2.0;
		String not = "";
		if(intDiv < doubleDiv)
			not = "NOT ";
		System.out.println(n + " is " + not + "even.");
	}
}
