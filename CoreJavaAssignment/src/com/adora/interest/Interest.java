package com.adora.interest;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double principal, rate, time;
		
		System.out.print("Pleae enter the principal amount: ");
		principal = sc.nextDouble();
		System.out.print("Please enter the interest rate: ");
		rate = sc.nextDouble();
		System.out.print("Please enter the amount of time:  ");
		time = sc.nextDouble();
		
		System.out.println();
		
		double interest = principal * rate * time;
		
		System.out.println("The interest is $" + interest  );
	
		sc.close();
		
	}

}
