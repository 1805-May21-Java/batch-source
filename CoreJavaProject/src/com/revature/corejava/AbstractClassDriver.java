package com.revature.corejava;

/*
 * Q18 from Core Java Assignment
 * 
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass.
 * Provide the following three implementations in the  subclass corresponding to the abstract methods in the superclass:
 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * 2. Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 3. Convert the input string to integer and add 10, output the result to the console.
 *
 * Create an appropriate class having a main method to test the above setup.
 */
public class AbstractClassDriver 
{

	public static void main(String[] args) 
	{
		//I am testing the implementation of my 3 inherited abstract methods 
		//containsUpperCase, toUpperCase, and toInteger
		AbstractClassImpl impl = new AbstractClassImpl();
		System.out.println(impl.containsUppercaseChars("string"));
		System.out.println(impl.containsUppercaseChars("sTrInG"));
		System.out.println(impl.toUpperCase("sTrInG"));
		System.out.println(impl.toInteger("200"));
//		System.out.println(impl.toInteger("fish")); //throws NumberFormatException
		
	}
}
