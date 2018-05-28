package com.revature.Q12;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		//Scanners accept the numbers for comparision
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in your first number: ");
		int num = sc.nextInt();
		System.out.println("Second Number: ");
		int num2 = sc.nextInt();
		
		//Ternary operator compares if the statement is true or false and returns the value in response
		int min = (num<num2) ? num:num2;
		System.out.println(+min+ " is the min");
	}

}
