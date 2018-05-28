package com.revature.htulipan.solutions.eighteen;

public class RealStringChecker extends StringChecker {

	public RealStringChecker() {
		super();
	}
	
	public boolean containsUppercase(String s) {
		char[] characters = s.toCharArray();
		for (char c : characters) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	public String convertToUppercase(String s) {
		return s.toUpperCase();
	}
	
	public void convertToLargerInt(String s) {
		Integer result;
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			System.out.println("Conversion of String to Integer failed due to String format.");
			result = null;
		}
		if (result == null) {
			System.out.println("No Integer Available");
		} else {
			System.out.print(result + 10);
		}
	}
	
}
