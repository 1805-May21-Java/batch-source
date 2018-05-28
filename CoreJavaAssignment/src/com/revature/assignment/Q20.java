package com.revature.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q20 {

	/*Q20. Create a notepad file called Data.txt and enter the following:

		Mickey:Mouse:35:Arizona
		Hulk:Hogan:50:Virginia
		Roger:Rabbit:22:California
		Wonder:Woman:18:Montana
		 
		Write a program that would read from the file and print it out to the screen in the following format:
		 
		Name: Mickey Mouse
		Age: 35 years
		State: Arizona State*/
	
public static void main(String[] args) {
		
		BufferedReader br = null;
		String path = "src/com/revature/assignment/Data.txt";
		
		
		
		try {
			br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			String[] splitline = line.split(":");
			
			//read file until there are no more lines to read
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
}
}


