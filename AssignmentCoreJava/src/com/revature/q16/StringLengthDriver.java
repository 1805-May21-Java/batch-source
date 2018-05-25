package com.revature.q16;

import java.util.*;

public class StringLengthDriver {
	public static void main (String[] args) {
		//create a Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("I'll tell you how long your string is. Enter one: ");
		//get line
		String string = sc.nextLine();
		//use .length method to calculate how long the string is
		System.out.println("That was " + string.length() + " characters long.");
	}
}
