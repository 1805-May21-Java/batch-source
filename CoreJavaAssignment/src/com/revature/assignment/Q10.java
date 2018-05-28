package com.revature.assignment;

public class Q10 {

	//Q10. Find the minimum of two numbers using ternary operators.
	
	//Used ternary operator to assign lower value to int that prints to console
	public void compareTwoNums (int a, int b) {
		if (a == b) {System.out.println("The numbers are the same");}
		else {
		int minimum;
		minimum = (a>b) ? b : a;
		System.out.println(minimum + " is the smaller number");
		}
		
//		Driver Code
//		Q10 q = new Q10();
//		q.compareTwoNums(10, 9);
		
	}
}
