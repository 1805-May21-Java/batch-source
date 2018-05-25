package com.revature.a2;

import java.util.Scanner;

public class Q4NFactorial {
	//set up the variables
	private int n;
	private int result;
	public void nFactorial() {
		Scanner scan = new Scanner(System.in);
		result = 1;
		try {//making sure a number is entered
			System.out.println("Please enter the number you want to find the factorial: ");
			//making sure the string change in to integer
			n = Integer.parseInt(scan.nextLine());
			
			for (int i = n; i > 0; i--) {//factorial function
				result *= i;
			}
		} catch(NumberFormatException e) {
			System.out.println("Must enter a number to fina factorial!");
		}
		//print out result
		System.out.println(result);
		System.out.println();
		
	}
	
	
}
