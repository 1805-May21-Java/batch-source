package com.revature.corejava;

import java.io.*;

/*
 * Q20 from Core Java Assignment
 * 
 * Create a notepad file called Data.txt and enter the following:
 *
 *Mickey:Mouse:35:Arizona
 *Hulk:Hogan:50:Virginia
 *Roger:Rabbit:22:California
 *Wonder:Woman:18:Montana
 *
 *Write a program that would read from the file and print it out to the screen in the following format:
 * 
 *Name: Mickey Mouse
 *Age: 35 years
 *State: Arizona State
 *
 */
public class FileReaderDemo 
{

	public static void main(String[] args) 
	{
	
		BufferedReader br = null;
		String path = "src/com/revature/corejava/Data.txt";
		
		try 
		{
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			//I read input from Data.txt and use the split method to parse the String seperating by the :
			//I manually match the desired formats
			while(line != null)
			{
				String [] strArr = line.split(":");
				System.out.println("Name: " + strArr[0] + " " + strArr[1]);
				System.out.println("Age: " + strArr[2] + " years");
				System.out.println("State: " + strArr[3] + " State");
				System.out.println();
				line = br.readLine();
			}
		}
		catch (IOException e) //An IOException can be found if the file is not found
		{
			e.printStackTrace();
		}
		

	}
}
