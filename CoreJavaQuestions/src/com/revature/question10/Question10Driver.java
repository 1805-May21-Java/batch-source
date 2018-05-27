package com.revature.question10;

import java.util.ArrayList;
import java.util.Scanner;

public class Question10Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter number1: ");
		String str1 = s.nextLine();		
		System.out.println("Enter number2: ");
		String str2 = s.nextLine();		

		int minVal = (Integer.parseInt(str1) < Integer.parseInt(str2)) ? (Integer.parseInt(str1)) : (Integer.parseInt(str2));
		System.out.println("min: "+minVal);
	}
}
