package com.revature.main;
import java.io.IOException;

import com.revature.dao.*;
public class BankDriver
{
	public BankDriver() {};
	public static void main(String[] args)
	{
		try
		{
			while(true)
			{
				display screen = new display();
				screen.welcome();
			}		
		} catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}
