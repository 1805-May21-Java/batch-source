package com.revature.core_java_assignment;

public class Question3 {

	public static void main(String[] args) {
		String str = "Hello, World!";
		// to avoid using a temporary variable, iterate through the string backwards and add the 
		// characters to the existing string. Then, the substring from the middle of the string 
		// to the end will be the reversed string.
		for(int i = str.length() - 1; i >= 0; i--) { 
			str += str.charAt(i);
		}
		// str = Hello, World!!dlroW ,olleH
	    str = str.substring(str.length() / 2);
	    System.out.println(str);
	}

}
