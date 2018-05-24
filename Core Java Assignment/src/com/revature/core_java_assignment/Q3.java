package com.revature.core_java_assignment;

public class Q3
{
	public static void main(String[] args)
	{
		//declaring the string I want to reverse
		String message = "Hello world!";
		
		//using a for loop to reverse the string
		for(int i = 0; i < message.length(); i++)
		{
			//this gets the correct output
			//however declaring an empty string and doing emptyString += message.charAt(etc) would have made it a string also
			//instead of a bunch of characters on the same line
			//this reverses the string by starting at the char index at the back of message
			//since strings are just arrays of characters
			System.out.print(message.charAt(message.length()-i-1));
		}
	}

}
