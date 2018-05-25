package com.revature.a2;

import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCase {
	
	private static Scanner scan = new Scanner(System.in);
	
	//based on what option the person want to do goes to specific function below
	public void switchCase(String x) {
		switch(x){
			case "squareroot":
				squareroot();
				break;
			case "date":
				date();
				break;
			case "splitString":
				splitString();
				break;
			default:
				break;
		}
		
	}
	
	private int num;
	//return the square root
	private void squareroot() {
		System.out.println("Enter the number you want to square root: ");
		double roots = root();
		System.out.println("The square root is: "+ roots);
	}
	
	//the function that make sure the input will be int, and square root it
	private double root() {
		int num;
		try {
			num = Integer.parseInt(scan.nextLine());
			double root = (double) Math.sqrt(num);
			return root;
			
		}	catch (NumberFormatException e) {
			System.out.println("Invalid Input, please put in a number");
			return root();
		}
	}
	
	//fiund the current date from Date class imported
	private void date() {
		Date date = new Date();
		System.out.println("Current Date is: " + date.toString());
	}
	
	//separate the string by character and store each char in order into the string array made
	private String s = "I am learning Core Java";
	private String[] stringArray = new String[s.length()];
 	private void splitString() {
		
		for (int i = 0; i < s.length(); i++) {
			String a = "";
			a += s.charAt(i);
			stringArray[i] = a;
			System.out.println(stringArray[i]);
		}
	}
}
