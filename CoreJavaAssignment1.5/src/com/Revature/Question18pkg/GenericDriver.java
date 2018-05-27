package com.Revature.Question18pkg;

public class GenericDriver {
	public static void main(String args[]) {
		//Instantiate GenericSubClass
		GenericSubClass sub = new GenericSubClass();
		
		//Output has upper case method
		System.out.println(sub.hasUpperCase("asdasd"));
		System.out.println(sub.hasUpperCase("asdD"));
		
		//Output uppercase version of strings
		System.out.println(sub.toUpper("asdasd"));
		System.out.println(sub.toUpper("asdTHasd"));
		
		//Output the parsed integer plus ten
		System.out.println(sub.toIntPlusTen("123"));
		
		//Catch exception thrown when parse throws
		try {
			System.out.println(sub.toIntPlusTen("asd"));
		} catch (NumberFormatException e ) {
			System.out.println("Bad input");
		}
	}
}
