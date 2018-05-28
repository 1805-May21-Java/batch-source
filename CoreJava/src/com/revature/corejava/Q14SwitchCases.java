package com.revature.corejava;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q14SwitchCases {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		runProgram(sc);

	}
	
	public static void runProgram(Scanner sc) {
		// get input from user
		System.out.println("Enter 1 to compute a square root, 2 to display " +
						"todays date, or 3 to split a string: ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: // compute the square root
			System.out.println("Enter an int: ");
			int num = sc.nextInt();
			System.out.println("Square root of " + num + " is " + Math.sqrt(num));
			break;
		case 2: // display today's date using Date
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println("Today's date is " + dateFormat.format(date));
			break;
		case 3: // split string and store in array
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");
			System.out.println("Fourth word in string is " + arr[3]);
			break;
		default:
			System.out.println("Invalid input");
			runProgram(sc);
			break;
		}
			
	}

}
