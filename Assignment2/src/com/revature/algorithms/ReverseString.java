package com.revature.algorithms;

public class ReverseString {

	public ReverseString() {
		super();
	}

	// Reverses string str and returns its reversal
	public static String reverseString(String str) {
		StringBuffer reverseStr = new StringBuffer();

		for(int i = 0; i < str.length(); i++) {
			reverseStr.append(str.charAt(str.length() - i - 1));
		}
		
		return reverseStr.toString();
	}
}
