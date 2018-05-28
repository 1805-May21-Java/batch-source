package com.revature.htulipan.solutions.twenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Q20. Create a notepad file called Data.txt and enter the following:


Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State
 */

public class SolutionTwentyDriver {
	public static void main(String[] args) {
		BufferedReader br = null;
		String path = "src/com/revature/htulipan/solutions/twenty/Data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {
				parseDataLine(line);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	public static void parseDataLine(String s) {
		String[] dataPieces = s.split(":");
		System.out.println("Name: " + dataPieces[0] + " " + dataPieces[1]);
		System.out.println("Age: " + dataPieces[2] + " years");
		System.out.println("State: " + dataPieces[3] + " State");
	}
}
