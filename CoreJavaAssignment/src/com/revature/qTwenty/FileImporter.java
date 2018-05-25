package com.revature.qTwenty;

import java.io.*;

public class FileImporter
{
	public static void main(String[] args)
	{
		BufferedReader br = null;
		String path ="src/com/revature/qTwenty/Data.txt";
		
		try 
		{
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			while(line != null)
			{
				String[] values = line.split(":");
				System.out.println("Name: " + values[0] + " " + values[1]);
				System.out.println("Age: " + values[2] + " years");
				System.out.println("State: " + values[3] + " State");
				System.out.println();
				line = br.readLine();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}

	}
}
