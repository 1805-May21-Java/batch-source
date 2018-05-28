package com.revature.htulipan.solutions.eighteen;

/*
 * Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
 * Provide the following three implementations in the  subclass corresponding to the abstract methods in the superclass:
         
1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. Convert all of the lower case characters to uppercase in the input string, and return the result.
3. Convert the input string to integer and add 10, output the result to the console.
 */

public class SolutionEighteenDriver {

	public static void main(String[] args) {
		RealStringChecker rc = new RealStringChecker();
		
		System.out.println("Testing First Implementation: ");
		System.out.println("\"StringWithUppercase\" -> " + rc.containsUppercase("StringWithUppercase"));
		System.out.println("\"stringwithoutuppercase\" -> " + rc.containsUppercase("stringwithoutuppercase"));
		System.out.println("An empty string. -> " + rc.containsUppercase(""));
		
		System.out.println();
		
		System.out.println("Testing Second Implementation: ");
		System.out.println("\"StringWithUppercase\" -> " + rc.convertToUppercase("StringWithUppercase"));
		System.out.println("\"stringwithoutuppercase\" -> " + rc.convertToUppercase("stringwithoutuppercase"));
		System.out.println("An empty string. -> " + rc.convertToUppercase(""));
		
		System.out.println();
		
		System.out.println("Testing Third Implementation: ");
		System.out.print("\"10\" -> ");
		rc.convertToLargerInt("10");
		System.out.print("\n");
		System.out.print("\"-10\" -> ");
		rc.convertToLargerInt("-10");
		System.out.print("\n");
		System.out.print("An empty string. -> ");
		rc.convertToLargerInt("");
		System.out.print("\n");
	}

}
