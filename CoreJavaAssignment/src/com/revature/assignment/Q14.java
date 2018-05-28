package com.revature.assignment;

import java.util.Arrays;
import java.util.Date;

public class Q14 {

	/*Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
	Case 1: Find the square root of a number using the Math class method.
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a string array.
	           	“I am learning Core Java”*/

	String command = "";
	double sn = 49;
	Date today = new Date();
	String string = "I am learning Core Java";
	
	//Method takes string command to determine which function to demonstrate
	public void Switch(String command) {
		switch (command) {
		case "Square": System.out.println("The square root of " +sn+ " is " + Math.sqrt(sn));
		break;
		case "Date": System.out.println("Today's date is " + today);
		break;
		case "Split": String[] s = string.split(" ");
		System.out.println(Arrays.toString(s));
		
		break;
		default: System.out.println("Seacrest...OUT");
		
		}
		
		/*Driver Code
		Q14 q = new Q14();
		q.Switch("Square");
		q.Switch("Date");
		q.Switch("Split");*/
	}
}
