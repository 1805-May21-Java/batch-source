package com.revature.htulipan.solutions.five;

/*
 * Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the  existing substring methods in the String, StringBuilder, or StringBuffer APIs. * 
 */

public class SolutionFiveDriver {

	public static void main(String[] args) {
		String test = "substringofthislargerstring";
		System.out.println(substring(test, 9));
		
	}

	public static String substring(String s, int idx) {
		if (idx < 1 || idx > s.length()) {
			return "";
		}
		
		char[] characters = new char[idx];
		for (int i = 0; i < idx; i++) {
			characters[i] = s.charAt(i);
		}
		return String.valueOf(characters);
	}
}
