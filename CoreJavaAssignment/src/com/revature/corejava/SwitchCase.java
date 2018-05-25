package com.revature.corejava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Q14
public class SwitchCase {

	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		switchDemo(1);
		switchDemo(2);
		switchDemo(3);
	}

	public static void switchDemo(int i){
		switch(i) {
		case 1:
			int num = (int)(Math.random()*50000);
			System.out.println("The square root of "+num+" is: "+Math.sqrt(num));
			break;
		case 2:
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Todays Date is: "+format.format(date));
			break;
		case 3:
			String string = "I am learning Core Java";
			String[] split = string.split(" ");
			for(String s: split) {
				System.out.println(s);
			}
			break;
		default:
			break;
		}
	}
	
}
