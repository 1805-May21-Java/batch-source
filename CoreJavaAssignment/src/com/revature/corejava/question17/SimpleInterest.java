package com.revature.corejava.question17;

import java.util.Scanner;

public class SimpleInterest {
	// Double variables to hold the principal, rate, and number of years. Scanner scanner to get input. String 
	// which to store user options
	private double principal;
	private double rate;
	private double time;
	private Scanner scanner=new Scanner(System.in);
	private String which;

	// Constructor that calls the super class
	public SimpleInterest() {
		super();
	}

	// Method to calculate the simple interest
	public void calculateInterest() {
		System.out.println("Welcome to Simple Intrest Calculator");
		System.out.println();
		
		// Sets principal to the next double entered by the user
		System.out.println("Please enter Principal amount");
		principal=scanner.nextDouble();
		
		// Sets the rate to the next double entered by the user
		System.out.println("Please enter Rate of Intrest");
		rate=scanner.nextDouble();
		
		// Sets the time to the next double entered by the user
		System.out.println("Please enter Number of Years");
		time=scanner.nextDouble();
		System.out.println();
		
		// Calculates and prints out the simple interest for the user
		System.out.printf("Your intrest will be $ %,.2f",principal*(rate/100)*time);
		System.out.println();
		
		// Gives the user the option to run the program again
		System.out.println("Would you like to calculate again? Please type yes or no.");
		which=scanner.nextLine();
		switchCase();
	}
	
	// Method to determine whether or not to call calculateInterest again and re-run the program
	// Typing yes will call calculateInterest
	// Typing no will end the program
	// Any other entries will print an error message and call switchCase again
	private void switchCase() {
		
		switch(which) {
		case "yes":
			System.out.println();
			calculateInterest();
			break;
		case "no":
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Invalid, please try again. Please type yes or no");
			which=scanner.nextLine();
			switchCase();
		}
		
	}
	
}
