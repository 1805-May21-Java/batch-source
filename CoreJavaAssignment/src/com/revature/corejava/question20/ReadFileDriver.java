package com.revature.corejava.question20;

public class ReadFileDriver {

	public static void main(String[] args) {
		
		// Instantiate new ReadFile object using the path to the Data.txt file as an argument
		ReadFile readFile = new ReadFile("src/com/revature/corejava/question20/Data.txt");
		
		// Runs the read file method to print the information
		readFile.readFile();

	}

}
