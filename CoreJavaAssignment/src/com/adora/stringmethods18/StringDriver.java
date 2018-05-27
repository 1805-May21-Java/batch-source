package com.adora.stringmethods18;

public class StringDriver {

	public static void main(String[] args) {
	
		StringSub tester =  new StringSub();
		String stringWithUpper = "Hello, this is a test.";
		String noUpper = "good evening";
		String number1 = "ten";
		String number2 = "13";
		
		
		//test hasUpperCase
		System.out.println(tester.hasUppercase(stringWithUpper)? "correct: true" : "incorrect: false");
		System.out.println(tester.hasUppercase(noUpper)? "incorrect: true" : "correct: false");
		
		//testing convert to uppercase
		System.out.println(tester.convertLowerToUpper(stringWithUpper));
		System.out.println(tester.convertLowerToUpper(noUpper));
		
		//testing add ten to string
		tester.addTenToString(number1);
		tester.addTenToString(number2);
	}

}
