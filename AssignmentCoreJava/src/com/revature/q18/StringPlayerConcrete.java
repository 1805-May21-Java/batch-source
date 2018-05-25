package com.revature.q18;

public class StringPlayerConcrete extends StringPlayerAbstract{

	@Override
	public boolean hasUppercase(String string) {
		boolean hasUpper = false;
		for(int i = 0; i < string.length(); i++) {
			if(Character.isUpperCase(string.charAt(i))) {
				hasUpper = true;
			}
		}
		return hasUpper;
	}

	@Override
	public String makeUppercase(String string) {
		String capsLock = "";
		for(int i = 0; i < string.length(); i++) {
			capsLock += Character.toUpperCase(string.charAt(i));
		}
		return capsLock;
	}

	@Override
	public int turnToInteger(String string) {
		int num;
		try {
			num = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			System.out.println("Could not convert string to int.");
			return 0;
		}
		return num + 10;
	}
}
