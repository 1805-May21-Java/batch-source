package com.revature.assignment;

import java.util.Scanner;

public class QuestionSeventeen {
	
	//scanner to read console
	private static Scanner sc = new Scanner(System.in);

	//a method made to calculate interest, multiplies the three variables together
	public static float calcInterest(float principal, double rate, int time) {
		float interest = (float) (principal*rate*time);
		System.out.println(interest);
		return interest;
	}
	
	public static void main(String[] args) {

		//prompts the user for the principal
		System.out.println("Please enter the amount of the principal:");
		float principal = sc.nextFloat();
		
		//prompts the user for the rate
		System.out.println("Please enter the rate:");
		double rate = sc.nextDouble();
		
		//prompts the user for the amount of time
		System.out.println("Please enter the amount of time:");
		int time = sc.nextInt();

		//returns the total interest
		System.out.println("The simple interest total calculates to be $"+calcInterest(principal, rate, time));
		
	}

}
