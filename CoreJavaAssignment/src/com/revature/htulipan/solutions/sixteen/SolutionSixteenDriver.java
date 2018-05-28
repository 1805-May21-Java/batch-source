package com.revature.htulipan.solutions.sixteen;

import java.util.Scanner;

/*
 * Q16. Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args) or using the scanner class.
 */

public class SolutionSixteenDriver {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some text input: ");
		String input = sc.nextLine();
		System.out.println("The number of characters you entered was: " + input.length());
	}

}
