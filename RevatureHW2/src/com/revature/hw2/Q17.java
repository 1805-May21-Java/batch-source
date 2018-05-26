package com.revature.hw2;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int principal, rate, time, total = 0;
		System.out.println("Please enter the Principal.");
		principal = Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the Rate.");
		rate = Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the Time.");
		time = Integer.parseInt(sc.nextLine());
				
		total = principal * rate * time;

		System.out.println("The interest of the values inputted is " + total);
	}
}