package com.revature.bank;
import java.io.IOException;
public class Driver
{

	public Driver()
	{
		
	}
	public static void main(String[] args)
	{
		try
		{
			while(true)
			{
				Display.welcome();
				Display.transaction();
			}		
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		

		
	}

}
