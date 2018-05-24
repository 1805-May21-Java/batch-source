package core_java_assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Question18 extends Question18AbstractClass{

	@Override
	public boolean hasUppercase(String string) {
		for(int i = 0; i<string.length(); i++) {
			if(Character.isUpperCase(string.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowerCaseToUpperCase(String string) {
//		String[] returnString = string.split("(?!^)");
		StringBuffer returnString = new StringBuffer(string);
		for(int i = 0; i < string.length(); i++) {
			if(Character.isLowerCase(string.charAt(i))) {
				returnString.setCharAt(i, Character.toUpperCase(string.charAt(i)));
			}
		}
		return returnString.toString();
	}

	@Override
	public int stringToIntegerPlusTen(String string) {
		try {
			return Integer.parseInt(string) + 10;
		} catch (NumberFormatException e) {
			System.out.println("Not an parsable integer.");
			return 0;
		}
	}

}
