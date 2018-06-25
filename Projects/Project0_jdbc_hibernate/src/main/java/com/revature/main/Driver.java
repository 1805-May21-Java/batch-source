package com.revature.main;
import java.io.IOException;


public class Driver
{
	public Driver()
	{
		super();
	}

	public static void main(String[] args)
	{
	try
		{
			while(true)
			{
				Display display = new Display();
				display.welcome();
			}		
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
