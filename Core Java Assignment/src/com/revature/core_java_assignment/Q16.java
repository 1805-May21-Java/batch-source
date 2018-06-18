package com.revature.core_java_assignment;
import java.util.Scanner;

public class Q16
{

	public static void main(String[] args)
	{
		//went with the scanner instead of the cmd prompt
		Scanner sc = new Scanner(System.in);
		String str;
		
		//this question was pretty simple
		//just had to get the string from user input and call it's .length() to return the number of characters
		System.out.println("Please input a string");
		str = sc.nextLine();
		
		System.out.println("The number of characters in this string are: " +str.length() );
	}

}
