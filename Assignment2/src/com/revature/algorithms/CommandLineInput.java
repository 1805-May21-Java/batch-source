package com.revature.algorithms;

public class CommandLineInput {

	public CommandLineInput() {
		super();
	}

	// takes command line args as an argument and simply returns the length of the first arg
	public static int arg0Length(String[] args) {
		return args[0].length();
	}
}
