package com.adora.stringmethods18;

public class StringSub extends StringSuper {

	@Override
	boolean hasUppercase(String str) {
		String lower = str.toLowerCase();
		return !str.equals(lower);
	}

	@Override
	String convertLowerToUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	void addTenToString(String str) {
		try {
			int number = Integer.parseInt(str);
			System.out.println(number + 10);
		} catch (NumberFormatException e) {
			System.out.println(str + " could not be converted to a number.");
		}
	}

	
}
