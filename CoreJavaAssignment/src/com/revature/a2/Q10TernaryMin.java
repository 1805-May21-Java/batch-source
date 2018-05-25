package com.revature.a2;

public class Q10TernaryMin {
	
	//set up the varaibles
	private int min;
	
	public void ternaryMin(int a, int b) {
		if( a == b) {
			// if they are equal get this out
			System.out.println("None, they are equal to each other");
		} else {
			//ternary operator, check whether to go a or b based on who is smaller
			min = (a < b)? a : b;
			System.out.println("The number that is less are: " + min);
		}
	}
}
