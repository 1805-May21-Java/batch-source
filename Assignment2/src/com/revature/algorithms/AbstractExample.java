package com.revature.algorithms;

public abstract class AbstractExample {

	public AbstractExample() {
		super();
	}

	// checks if str contains any uppercase letters, returns true if so, false otherwise
	abstract boolean checkUppercase(String str);

	// converts all lowercase letters to uppercase and returns the result
	abstract String lowerToUpper(String str);
	
	// converts the string to an integer by parsing, then adds 10 and returns the result
	abstract int addTen(String str);
}
