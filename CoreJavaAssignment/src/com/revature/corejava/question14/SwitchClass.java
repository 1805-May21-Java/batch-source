package com.revature.corejava.question14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class SwitchClass {
	
	// Initialize variable which to act as the switch variable and Instantiate a new Scanner object sc to get user
	// input
	private int which=0;
	private Scanner sc=new Scanner(System.in);

	// Constructor that calls to the super class
	public SwitchClass() {
		super();
	}
	
	/*
	 * Method to start a loop that will ask user for input and use a switch case to determine the action that it
	 * will take based on user input
	 * 
	 * First, it prints out a greeting
	 * 
	 * Then a while loop is called that will continue until the which variable is set to -1
	 * 
	 * A series of statements are printed that instruct the user on how to use the program
	 * 
	 */
	public void runSwitch() {
		System.out.println("Welcome to Switch Class");
		
		while(which!=-1) {
			System.out.println("1. Find the square root of a number");
			System.out.println("2. Get todays date");
			System.out.println("3. Split the string \"I am learning Core Java\" into an array");
			System.out.println("Enter -1 to exit");
			
			which=sc.nextInt();
			
			switch(which) {
			// Print goodbye message when user is done
			case -1:
				System.out.println("Goodbye!");
				break;
				
			// Gets the next user entry and stores it as a string into variable square
			// Trys to parse the string to a double and print it in a message, if it can't it will print error message
			// and the program will reset, otherwise it will print and the message will still restart
			case 1:
				System.out.println("Enter number");
				String square=sc.next();
				try {
					System.out.println("The square root of your number is "+
							Math.sqrt(Double.parseDouble(square)));
				}catch(Exception e) {
					System.out.println("Invalid Entry");
				}
				
				System.out.println();
				break;
			// DateTimeFormatter is instantiated to format the date
			// Variable now is instantiated and set to today with the now method
			// The date is then printed by putting the now variable in the DateTimeFormatter's format method
			case 2:
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
				LocalDateTime now = LocalDateTime.now();
				System.out.println("Today is "+dtf.format(now));
				System.out.println();
				break;
			// String string is set to "I am learning Core Java"
			// The string is then split by space with split method and the strings are stored into array
			// The strings in array are then printed out separately to show they have been split
			case 3:
				String string="I am learning Core Java";
				System.out.println("Here is the string");
				System.out.println(string);
				
				String[] array=string.split(" ");
				
				System.out.println("Here is the array after the string is split");
				
				System.out.print("[");
				for(int i=0;i<array.length-1;i++) {
					System.out.print(array[i]+", ");
				}
				System.out.println(array[array.length-1]+"]");
				System.out.println();
				break;
			// If the users input does not match any of the options, then the error message is printed
			default:
				System.out.println("Invalid Entry");
				System.out.println();
				break;
			}
		}
	}

}
