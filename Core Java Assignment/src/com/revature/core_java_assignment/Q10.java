package com.revature.core_java_assignment;

import java.util.Scanner;

public class Q10
{

	public static void main(String[] args)
	{
		//decided to add a scanner and make it a bit more dynamic
		int num1;
		int num2;
		Scanner sc = new Scanner(System.in);
		
		//getting the numbers
		System.out.println("Please enter the first number number");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.println("Please enter the second number ");
		num2 = Integer.parseInt(sc.nextLine());
		
		//finding the minimum and displaying it
		int min = (num1 < num2)? num1:num2;
		System.out.println(min + " is the smallest number");
	}

}
