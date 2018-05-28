package com.revature.corejava;

import java.util.Date;

/*
 * Q14 from Core Java Assignment
 * 
 * Write a program that demonstrates the switch case.
 *  Implement the following functionalities in the cases: 
 *Case 1: Find the square root of a number using the Math class method.
 *Case 2: Display today’s date.
 *Case 3: Split the following string and store it in a string array.
 *          	“I am learning Core Java”
 */
public class SwitchDemo {

	public static void main(String[] args) 
	{
		//Demos a switch based on whether sqrt, date, or split is given.
		System.out.println("Case demo: ");
		demo("sqrt");
		demo("date");
		demo("split");
		
	}
	
	private static void demo(String str)
	{
		switch(str)
		{
			case "sqrt":
				{
					
				Math.sqrt(121);
				break;
				}
			case "date":
			{
				System.out.println(new Date().toString());
				break;
			}
			case "split":
			{
				String[] strArr = "I am learning Core Java".split(" ");
				break;
			}
		}
	
	
	
	}

}
