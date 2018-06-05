package com.revature.main;
import java.io.IOException;

import com.revature.dao.UserDaoImpl;
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
				Display display = new Display();
				display.welcome();
			}		
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		

		
	}

}
