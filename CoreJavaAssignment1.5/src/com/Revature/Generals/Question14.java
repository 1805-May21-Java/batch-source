package com.Revature.Generals;

import java.util.Date;

public class Question14 {
	public static void randSqrt() {
		int n = (int) (Math.random() * 100); //Get random integer 0-100
		System.out.println(Math.sqrt(n)); //Print square root of n
	}

	public static void displayDate() {
		Date d = new Date(); //Displays current date
		System.out.println(d.toString());
	}

	public static void strSplit() {
		String str = "I am learning Core Java";

		String strArr[] = str.split(" "); //Splits string based on spaces

		for (String nStr : strArr ) {
			System.out.println(nStr);
		}
	}

	public static void switchEx(int n) {
		switch (n) { //Switch based on n
		case 1:
			randSqrt();
			break;
		case 2:
			displayDate();
			break;
		case 3:
			strSplit();
			break;
		default: //Print error msg for other cases
			System.out.println("Bad input");
			break;
		}
	}

	public static void main(String args[]) {
		switchEx(1);
		switchEx(2);
		switchEx(3); //Test all cases
	}
}
