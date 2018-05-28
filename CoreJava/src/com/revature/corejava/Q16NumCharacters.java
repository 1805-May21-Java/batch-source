package com.revature.corejava;

import java.util.Scanner;

public class Q16NumCharacters {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter a string: ");
		String input = sc.nextLine(); // get string from user
		
		// print the number of characters (length of string)
		System.out.println("Number of characters in string: " + input.length());

	}

}
