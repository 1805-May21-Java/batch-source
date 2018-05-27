package com.Revature.Generals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {
	public static void parseDataStr(String dataPoint) throws IOException { //Method parses single data point
		String arr[] = dataPoint.split(":"); //Split colon separated data point

		if (arr.length < 4) { //If there are less than 4 separate strings, the file format is incorrect
			throw new IOException("Invalid input"); //Throw exception for bad inputs
		}
		
		String name = arr[0] + arr[1]; //First two elements are the name
		String age = arr[2]; //Next is the age
		String location = arr[3]; //Final is the location
		
		//Output data as information
		System.out.println("Name: " + name );
		System.out.println("Age: " + age + " years");
		System.out.println("State: " + location + " State");
		
		//Endline for prettiness
		System.out.println();
	}

	public static void main(String args[]) {
		//Define path for file
		String path = ".\\Data.txt";

		//Open pat to check if file exists
		File file = new File(path);
		if (!file.exists()) {
			//Output error if file is not present
			System.out.println("Error in opening file");
			System.exit(1);
		}

		//Try with resources to close readers
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line = null; //Start line at null
			do {
				line = br.readLine(); //Read from file
				if (line != null ) { //If line is not null, parse it
					parseDataStr(line);
				}
			} while( line != null ); //Leave loop when line is null
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
