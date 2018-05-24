package com.Revature.pkg;

public class SubstringDriver {
	public static String getSubString(String str, int upperBound) {
		String rstring = ""; //Initialize empty string
		for ( int i = 0; i < upperBound; i++ ) { //Iterates up to the upperBound
			rstring += str.charAt(i); //Adds str at index i to the return String
		}
		
		return rstring;
	}
}
