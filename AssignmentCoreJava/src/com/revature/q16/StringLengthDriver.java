package com.revature.q16;

import java.util.*;

public class StringLengthDriver {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("I'll tell you how long your string is. Enter one: ");
		String string = sc.nextLine();
		System.out.println("That was " + string.length() + " characters long.");
	}
}
