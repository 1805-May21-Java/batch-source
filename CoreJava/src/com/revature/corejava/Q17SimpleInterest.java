package com.revature.corejava;

import java.util.Scanner;

public class Q17SimpleInterest {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// get the principal, rate of interest, and number of years from user:
		System.out.println("Enter principal amount: ");
		float principal = sc.nextFloat();
		System.out.println("Enter the interest rate: ");
		float interestRate = sc.nextFloat();
		System.out.println("Enter the number of years (int): ");
		int numYears = sc.nextInt();
		
		System.out.println("Interest is: " + principal * interestRate * numYears);
	}

}
