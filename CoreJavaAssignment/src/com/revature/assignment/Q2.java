package com.revature.assignment;

public class Q2 {
	
	
	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	
	//Loop that prints a number and then saves the sum of all previous numbers 
	 public static void fibonacci() {
		int f = 0;
		int c = 1;
		for(int i=1; i < 25; i++) {
			
			System.out.println(f);
			int sum = f+c;
			f = c;
			c = sum;
			
		}
	}
	 	//Driver code
//	 	Q2 q = new Q2();
//		q.fibonacci();
	}
