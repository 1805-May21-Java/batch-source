package com.revature.htulipan.solutions.fourteen;

/*
 * Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
                   “I am learning Core Java”
 */

public class SolutionFourteenDriver {

	public static void main(String[] args) {
		System.out.println("Feeding the Switcher the value 1:");
		Switcher.doASwitch(1);
		System.out.println("Feeding the Switcher the value 2:");
		Switcher.doASwitch(2);
		System.out.println("Feeding the Switcher the value 3: ");
		Switcher.doASwitch(3);
		System.out.println("Feeding the Switcher the value 4: ");
		Switcher.doASwitch(4);
	}

}
