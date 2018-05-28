package com.revature.corejava.question10;

public class MinimumDriver {

	public static void main(String[] args) {
		
		// Create new findMinimum object with the values of one and two set to 7 and 5, respectively
		FindMinimum fm=new FindMinimum(7,5);
		
		// Test 7,5 pair with the larger number being set in the one variable
		// Should return 5
		System.out.print("The minimum between 7 and 5 is ");
		System.out.println(fm.getMinimum());
		
		// Provied space between tests
		System.out.println();
		
		// Change the values of one and two to 3 and 8, respectively
		fm.newNumbers(3, 8);
		
		// Test 3,8 pair with the larger number being set in the two variable
		// Should return 3
		System.out.print("The minimum between 3 and 8 is ");
		System.out.println(fm.getMinimum());

	}

}
