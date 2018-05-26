package com.revature.hw2;

import java.util.Scanner;

public class q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num, total = 1;
		System.out.println("Please enter the first number.");
		num = Integer.parseInt(sc.nextLine());
				
		for(int x = 1; x <= num; x++) {
			total = total * x;
		}

		System.out.println("The result of "+ num +"! is " + total);
	}
}