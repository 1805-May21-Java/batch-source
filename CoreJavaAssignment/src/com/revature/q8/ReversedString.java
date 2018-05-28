package com.revature.q8;

public class ReversedString {
	
	public String reverseString(String inputString) {
		String str = inputString;
		String reverseStr = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}
		
		return reverseStr;

	}

	
}
