package com.revature.hw2;

import java.util.Date;

public class Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 3;
	    Date date = new Date();
		
		switch(num) {
		case 1:
			System.out.println("The square root of 49 is " + Math.sqrt(49));
			break;
		case 2:
			System.out.println("Today's date is " + date.toString());
			break;
		case 3:
			String str1 ="I am learning";
			String str2 = "Core Java";
			System.out.println(str1 + " " +str2);
			break;
		}
	}
}