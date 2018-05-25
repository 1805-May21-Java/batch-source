package com.revature.q03;

public class ReverseStringDriver {
	public static void main(String[] args) {
		String s = "Hello World!";
		
		System.out.println("I will reverse \"" + s + "\"");
		System.out.println(reverseString(s));
	}
	
	static String reverseString(String string) {
		//The end condition is if the string is only 1 character long
		if (string.length() == 1) {
			return string;
		}		
		/*
		 * here is where the string is being reversed, it returns the last letter
		 * and then recursively calls the rest of the string to be reversed and 
		 * appended to the last letter
		 */
		return string.substring(string.length()-1) 
				+ reverseString(string.substring(0, string.length()-1));
	}
}