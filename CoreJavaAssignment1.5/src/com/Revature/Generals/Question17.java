package com.Revature.Generals;

import java.text.NumberFormat;
import java.util.Scanner;

public class Question17 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); //Initialize scanner
		
		String strPrincipal , strRate , strTime; //Declare some variables
		int principal , time;
		double rate;
		
		try { //Try-Catch to get NumberFormatException
			System.out.print("Enter principal: "); //Get variables
			strPrincipal = sc.nextLine();
			principal = Integer.parseInt(strPrincipal);
			
			System.out.print("Enter rate: "); //Do appropriate casting
			strRate = sc.nextLine();
			rate = Double.parseDouble(strRate);
			
			System.out.print("Enter time: ");
			strTime = sc.nextLine();
			time = Integer.parseInt(strTime);
			
			double interest = principal * rate * time; //Calculate total interest
			//Output interest as currency
			System.out.println("Total interest is " + NumberFormat.getCurrencyInstance().format(interest));
		} catch (NumberFormatException e ) {
			System.out.println("Invalid input");
		}
	}
}
