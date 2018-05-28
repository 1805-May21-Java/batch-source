package com.revature.corejava.question18;

public class ConcreteClass extends AbstractClass{
	
	// Constructor that calls the super class
	public ConcreteClass() {
		super();
	}

	// Override checkUppercase method from parent abstract class
	// Returns true if the string variable contains an uppercase method by checking if it matches the regular expression
	@Override
	public boolean checkUppercase(String string) {
		return (string.matches("^.*[A-Z].*$"))?true:false;
	}

	// Override toUppercase method from parent abstract class
	// Returns the string variable in all uppercase letters
	@Override
	public String toUppercase(String string) {
		return string.toUpperCase();
	}

	// Override integerPlusTen method from parent abstract class
	// Returns an integer value of the string variable, plus 10
	@Override
	public int integerPlusTen(String string) {
		return Integer.parseInt(string)+10;
	}

}
