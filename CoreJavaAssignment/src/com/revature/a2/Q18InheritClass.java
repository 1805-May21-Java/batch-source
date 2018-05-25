package com.revature.a2;

public class Q18InheritClass extends Q18SuperClass{

	public void inheritClass (String s) {
		System.out.println("This String has uppercase is: " + hasUppercase(s));
		System.out.println("This String has been converted into Upper Class: " + convertToUpper(s));
		System.out.println("This is the int converted by this String: " + stringToInt(s));
	}

	@Override
	public boolean hasUppercase(String s) {
		for(int i = 0; i < s.length(); i++) {
			//check each character to see if they have uppercase
			if(Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String s) {
		//turn the string into all uppercase
		String a = s.toUpperCase();
		return a;
	}

	@Override
	public int stringToInt(String s) {
		try {
			//convert it to int if possible, else put in 10
			int a = Integer.parseInt(s);
			a += 10;
			return a;
		} catch (NumberFormatException e) {
			System.out.println("Not a number!");
			return 10;
		}
	}
	

}
