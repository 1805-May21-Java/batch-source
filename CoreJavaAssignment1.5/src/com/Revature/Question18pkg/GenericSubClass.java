package com.Revature.Question18pkg;

public class GenericSubClass extends GenericSuperClass { //Extends super class

	//implement abstract methods
	@Override
	public boolean hasUpperCase(String str) {
		for ( int i = 0; i < str.length(); i++ ) {
			char ch = str.charAt(i);
			
			//Check if character is upper case or not
			if ( Character.isUpperCase(ch)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toUpper(String str) {
		//Return str but all uppercase
		return str.toUpperCase();
	}

	@Override
	public int toIntPlusTen(String str) throws NumberFormatException {
		int i = Integer.parseInt(str); //Parse str to integer
		return i+10; //Add ten to return
	}
	
}
