package com.revature.core_java_assignment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Q14
{

	public static void main(String[] args)
	{
		//declaring variables
		Scanner sc = new Scanner(System.in);
		double num;
		int input;
		String[] arr = new String[4];
		String str = "I am learning Core Java";
			
		//getting user input to determine which case to execute
		System.out.println("Enter 1 for square root, 2 for the date, 3 for string");
		input = Integer.parseInt(sc.nextLine());
		
		
		switch(input)
		{
			case 1:
			{
				//the sqrt case needs the exception to catch people trying to sqrt negative numbers
				System.out.println("Please enter a number to square root");
				try
				{
					num = Integer.parseInt(sc.nextLine());
					System.out.println(Math.sqrt(num));
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid input. Please input an integer");
				}
				break;
			}
			case 2:
			{
				//found these useful objects in the java documentation
				//they format the date and get the time from the system
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDateTime now = LocalDateTime.now();
				System.out.println("The date is: " + dtf.format(now));
				break;
			}
			case 3:
			{
				//using .split() to split the string based on spaces
				//then adding it to the array
				arr = str.split(" ");
				System.out.println("Here is your string array:");
				for(int i = 0; i < arr.length; i++)
				{
					System.out.println(arr[i]);
				}
				break;
			}
		
		}
	}

}
