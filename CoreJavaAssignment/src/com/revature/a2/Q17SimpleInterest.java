package com.revature.a2;

import java.util.Scanner;

public class Q17SimpleInterest {
	
	//Scanner class
	private Scanner scan = new Scanner(System.in);
	
	public void simpleInterest() {
		int a = principle();
		double b = rate();
		int c = time();
		double d = a * b * c;
		System.out.println("The Interest of this Account is: " + d);
	}
	
	//seperate it into 3 parts so when people entered the wrong format, they have chance to redo for each one
	//instead of going through the whole program again
	private int principle() {
		int num;
		try {
			System.out.println("Please Enter the Principle: ");
			num = Integer.parseInt(scan.nextLine());
			return num;
		} catch(NumberFormatException e) {
			System.out.println("Not a number, try again!");
			return principle();
		}
	}
	
	private double rate() {
		double num;
		//rate is different cause it is most likely a double
		try {
			System.out.println("Please Enter the Interest Rate: ");
			num = Double.parseDouble(scan.nextLine());
			return num;
		} catch(NumberFormatException e) {
			System.out.println("Not a number, try again!");
			return rate();
		}
	}
	
	private int time() {
		int num;
		try {
			System.out.println("Please Enter the Number of Year: ");
			num = Integer.parseInt(scan.nextLine());
			return num;
		} catch(NumberFormatException e) {
			System.out.println("Not a number, try again!");
			return time();
		}
	}
}
