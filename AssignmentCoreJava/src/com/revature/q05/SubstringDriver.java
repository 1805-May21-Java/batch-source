package com.revature.q05;

public class SubstringDriver {
	public static void main(String[] args) {
		String s = "Bumble Bee";
		System.out.println(mySubstring(s, -1));
		System.out.println(mySubstring(s, 8));
		System.out.println(mySubstring(s, 15));
	}
	
	//This method just goes through each character in a string by index
	static String mySubstring(String str, int idx) {
		//Start with an empty string to build onto
		String newString = "";
		
		//If a negative number is entered return null
		if(idx < 0) {
			return null;
		}
		//If the user over counts how many characters are in a string, it just returns
		//the whole string
		if(idx > str.length()) {
			return str;
		}
		
		for (int i = 0; i < idx; i++) {
			//build string character by character
			newString += str.charAt(i);
		}
		
		//Return newly shortened string
		return newString;
	}
}
