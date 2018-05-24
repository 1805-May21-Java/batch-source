package com.revature.algorithms;
import java.util.Date;

public class Switch {

	public Switch() {
		super();
	}

	// executes the option in the switch statement based on the argument o
	public static void executeOption(int o) {
		switch(o) {
		case 1:
			double temp = 8;
			double sqrtTemp = Math.sqrt(temp);
			System.out.println("The square root of " + temp + " is " + sqrtTemp);
			break;
		case 2:
			Date d = new Date();
			System.out.println("Today's date is: " + d.toString());
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] split = str.split(" ");
			System.out.println("Original string: " + str);
			System.out.println("Split string:");
			for(String s: split)
				System.out.println(s);
			break;
		default:
			System.out.println("Whoops");
		}
	}
}
