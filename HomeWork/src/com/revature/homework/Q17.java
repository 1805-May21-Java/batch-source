package com.revature.homework;


import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);//using scanner class 
		
		System.out.println("enter principal");// allows user to enter principal amount
		double principal = input.nextDouble(); // takes prinicipal amount from the scanner 
		System.out.println("enter rate");
		double rate = input.nextDouble();
		System.out.println("enter timeInYears");
		double timeInYears = input.nextDouble();
		
	double simpleInterest = (principal * rate* timeInYears)/100; // formula to computer simple interest
		
		System.out.println(simpleInterest);// printing out the result
	
input.close();// closing the scanner 
	}


}
