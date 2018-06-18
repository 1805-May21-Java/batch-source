package com.revature.core_java_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20
{

	public static void main(String[] args)
	{
		//setting up the variables
		BufferedReader br = null;
		String path = "src/com/revature/core_java_assignment/Data";
		String line;
		String[] data = new String[4];

		//need a try catch block when reading from a file
		try
		{
			br = new BufferedReader(new FileReader(path));
			
			//using this while loop to read the line of the file and then put the split of it into the data array
			//which I then print out using the indices
			while((line = br.readLine()) != null)
			{
				data = line.split(":");
				System.out.println("Name: " + data[0]+" "+data[1]);
				System.out.println("Age: " +data[2]+ " years" );
				System.out.println("State: " + data[3]);
				System.out.println();
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
