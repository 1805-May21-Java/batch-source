package com.revature.htulipan.solutions.fourteen;

import java.util.Date;

public class Switcher {
	
	public static void doASwitch(int num) {
		switch (num) {
		case 1:
			int rand = (int) (Math.random() * 500 + 1);
			System.out.println("The square root of " + rand + " is " + Math.sqrt(rand));
			break;
		case 2:
			Date today = new Date();
			System.out.println("Today's date is " + today.toString());
			break;
		case 3:
			String javaString = "I am learning Core Java";
			String[] javaBits = javaString.split(" ");
			System.out.println("The string \"I am learning Core Java\" split into its constituent words looks like: ");
			for (String s : javaBits) {
				System.out.println(s);
			}
			break;
		default:
			System.out.println("This Switcher doesn't know what to do with the value " + num);
		}
	}
}
