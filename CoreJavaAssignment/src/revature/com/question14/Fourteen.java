package revature.com.question14;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

import com.revature.sharedfunctionality.intGetter;

public class Fourteen extends intGetter
{
	Scanner sc = new Scanner(System.in);
	
	
	public Fourteen()
	{
		super();
	}


	public void switchDemo()
	{
		System.out.print("Make your (numerial) choice!");
		int choice = getInt();
		switch(choice)
		{
			case 1:
				double number;
				System.out.print("Enter a number");
				try
				{
					number = sc.nextDouble();
					System.out.println(number + "^0.5 = " + Math.sqrt(number));
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a number");
				}
				break;
			case 2:
				System.out.println("It is " + new Date());
				break;
			default:
				String value = "I am learning Core Java";
				String[] newStrings = value.split("learning");
				for(int i = 0; i < newStrings.length; i++)
				{
					System.out.println("newStrings[" + i + "] = " + newStrings[i]);
				}
		}
	}
}
