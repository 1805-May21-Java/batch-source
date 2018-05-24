package com.revature.sharedfunctionality;

import java.util.Scanner;

public class intGetter
{
	Scanner sc = new Scanner(System.in);
	
	public int getInt()
	{
		int num;
		try
		{
			num = sc.nextInt();
			return num;
		}
		catch(NumberFormatException e)
		{
			System.out.println("You can only factorial an integer.  Please enter an integer: ");
			return getInt();
		}
	}
}
