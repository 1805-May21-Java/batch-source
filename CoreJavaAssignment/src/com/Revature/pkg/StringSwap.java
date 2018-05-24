package com.Revature.pkg;

public class StringSwap {
	public static String simpleReverse( String str ) {
		int n = str.length();
		
		for ( int i = n - 1; i >= 0; i-- ) { //Iterate backwards on string
			str = str + str.charAt(i); //Adds characters to string last to first creating a mirror
		}
	
		str = str.substring(n, str.length()); //Set str to be the sub string starting at n and ending at the size
		
		System.out.println(str);
		
		return str;
	}
}
