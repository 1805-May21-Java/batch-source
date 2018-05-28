package com.revature.corejava.question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	// Variable to hold the path to the Data.txt file
	String path;

	// Constructor that calls to the super class
	public ReadFile() {
		super();
	}

	// Constructor that calls to the super class and sets the variable path
	public ReadFile(String path) {
		super();
		this.path = path;
	}

	// Getter to return value of path variable
	public String getPath() {
		return path;
	}

	// Setter to set the path variable
	public void setPath(String path) {
		this.path = path;
	}
	
	/*
	 * Method to read the contents of the file specified by the path variable
	 * 
	 * Creates a file object using the path variable
	 * 
	 * Tries to create a FileReader using the file object, and a BufferedReader using the FileReader object
	 * 
	 * Sets line equal to the first line in the file
	 * While line is not empty, formatedLine method is called using line variable, and the returned string is printed
	 * The variable line is then set to the next line in the file
	 * 
	 * If Exception is thrown, stack trace is printed
	 * 
	 */
	public void readFile() {
		File file=new File(path);
		FileReader fr;
		BufferedReader reader;
		String line;
		try {
			fr=new FileReader(file);
			reader=new BufferedReader(fr);
			
			line=reader.readLine();
			while(line!=null) {
				System.out.println(formatLine(line));
				line=reader.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * Method for formating the way in which the information is presented
	 * 
	 * Splits the information in line variable into String array data
	 * 
	 * All Strings in data are added to the formatedString variable along with addition text for formating purposes
	 * 
	 * The String formatedString is returned
	 * 
	 */
	private String formatLine(String line) {
		String[] data=line.split(":");
		String formatedString="Name: ";
		
		formatedString+=data[0]+" "+data[1]+"\n";
		formatedString+="Age: "+data[2]+" years\n";
		formatedString+="State: "+data[3]+" State\n";
		
		return formatedString;
	}
}
