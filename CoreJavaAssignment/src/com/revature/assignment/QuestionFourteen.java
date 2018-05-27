package com.revature.assignment;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class QuestionFourteen {

	//initiate the scanner
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		//prompt the user on the cases
		System.out.println("Please select a case."
				+ "\nCase1: Find the square root of a number using the Math class funtion. "
				+ "\nCase2: Display today's date. "
				+ "\nCase3: Split the following string and store it in a string array 'I am learning Core Java'.");
				
		//scan the users choice
		String choice = sc.nextLine().toLowerCase();
		
		//switch determines case chosen
		switch(choice) {
		case "case1":
			//prompts the user for another input, square roots it with Math method
			System.out.println("Please enter an integer to find the square root of.");
			int num = sc.nextInt();
			System.out.println("The square root of "+num+ " is "+Math.sqrt(num));
			break;
		case "case2":
			//returns the current date with Date
			System.out.println("The current date is:");
			Date date = new Date();
			System.out.println(date);
			break;
		case "case3":
			//splits the string into a string array and spits it back out
			System.out.println("The phrase in a string array is:");
			String[] strArray = "I am learning Core Java".split(" ");
			System.out.println(Arrays.toString(strArray));
			break;
		default:
			System.out.println("Invalid Command.");
		}
	}

}
