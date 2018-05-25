package com.revature.q18;

public class StringPlayerConcrete extends StringPlayerAbstract{

	@Override
	public boolean hasUppercase(String string) {
		for(int i = 0; i < string.length(); i++) {
			//uses isUpperCase to check if the character is upper case
			if(Character.isUpperCase(string.charAt(i))) {
				//There's at least one upper case, return true
				return true;
			}
		}
		return false;
	}

	@Override
	public String makeUppercase(String string) {
		//create a string from this empty one
		String capsLock = "";
		//go through each character in the string
		for(int i = 0; i < string.length(); i++) {
			//append capitalized letter
			capsLock += Character.toUpperCase(string.charAt(i));
		}
		//return result
		return capsLock;
	}

	@Override
	public int turnToInteger(String string) {
		int num;
		try {
			//parses int string into an int
			num = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			//if anything other than a digit is enter, this is returned
			System.out.println("Could not convert string to int.");
			return 0;
		}
		//if passes parse, return + 10
		return num + 10;
	}
}
