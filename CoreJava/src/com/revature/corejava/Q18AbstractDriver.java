package com.revature.corejava;

import java.util.Scanner;

public class Q18AbstractDriver {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		MyClass mc = new MyClass(); // get instance of MyClass
		
		// test implementations of abstract methods in MyClass
		System.out.println("Enter a string: ");
		String test = sc.nextLine();
		if (mc.checkUppercase(test)) {
			System.out.println("String contains uppercase characters");
		} else {
			System.out.println("No uppercase characters were found");
		}
		
		System.out.println("Enter another string: ");
		test = sc.nextLine();
		System.out.println(mc.lowerToUpper(test));
		
		System.out.println("Enter an integer: ");
		test = sc.nextLine();
		System.out.println("Add 10 and the sum is " + mc.stringToInt(test));
		
	}

}
