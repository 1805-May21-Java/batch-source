package com.revature.assignment;

public class Q4 {

	//Q4. Write a program to compute N factorial.
	
	//Method takes int parameter and multiplies all ints leading up to it
	public void factorial(int n) {
		
		int product = 1;
		for(int i = 1; i <= n; i++) {
			
			product = product * i;
		}
		System.out.println(product);
	}
	
}
		//Driver code
		//Q4 q = new Q4();
		//q.factorial(7);
