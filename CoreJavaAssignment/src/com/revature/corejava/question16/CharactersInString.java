package com.revature.corejava.question16;

public class CharactersInString {

	public static void main(String[] args) {

		// Initializes count variable to 0
		// Loops through all the Strings in args and prints out how may characters each one has
		int count=0;
		for(String arg:args) {
			System.out.println("There are "+arg.length()+" characters in "+arg);
		}
	}

}
