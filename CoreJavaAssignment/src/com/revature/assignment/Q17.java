package com.revature.assignment;

import java.util.Scanner;

public class Q17 {

	/*Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
	Enter principal, rate and time through the console using the Scanner class.
	Interest = Principal* Rate* Time  */
	
	//Uses Scanner to ask the user to input Principal, interest rate, and years of term
	public void calculateInterest() {
		double principal;
		double rateofinterest;
		double years;
		double simpleInterest;
		final Scanner sc = new Scanner(System.in);
		System.out.println("Principal amount ($):");
		principal = Double.parseDouble(sc.nextLine());
		
		System.out.println("Rate of Interest (%):");
		rateofinterest = (Double.parseDouble(sc.nextLine()))/100;
		
		System.out.println("Amount of Years (years):");
		years = Double.parseDouble(sc.nextLine());
		
		simpleInterest = principal * rateofinterest * years;
		System.out.println("Your simple interest is: " + simpleInterest);
		
		
		/*Driver Code
		Q17 q = new Q17();
		q.calculateInterest();*/
		
		
	}

}
