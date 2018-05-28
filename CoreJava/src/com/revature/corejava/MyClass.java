package com.revature.corejava;

public class MyClass extends MyAbstract {

	boolean checkUppercase(String str) {
		// if string has no uppercase chars, then the string will be equal to
		// itself after being converted to lowercase
		return !str.equals(str.toLowerCase());
	}

	String lowerToUpper(String str) {
		// convert all lowercase characters into uppercase
		return str.toUpperCase();
	}

	int stringToInt(String str) {
		// convert string into int, then output result
		int i = Integer.parseInt(str);
		return i + 10;
	}
	 
}
