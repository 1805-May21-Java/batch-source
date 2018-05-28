package com.revature.corejava.question18;

public class ConcreteDriver {

	public static void main(String[] args) {
		
		// New instance of ConcreteClass
		ConcreteClass cc = new ConcreteClass();
		
		// Check the checkUppercase method
		// Should print true
		System.out.println("Check for uppercase letters");
		System.out.println(cc.checkUppercase("hello World"));
		System.out.println();
		
		// Check the toUppercase method
		// Should print HELLO WORLD
		System.out.println("Return string with all letters capitalized");
		System.out.println(cc.toUppercase("hello World"));
		System.out.println();
		
		// Check the integerPlusTen method
		// Should return 25
		System.out.println("Return string as integer plus 10");
		System.out.println(cc.integerPlusTen("15"));
		System.out.println();

	}

}
