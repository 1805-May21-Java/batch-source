package com.revature.core_java_assignment;
import java.util.Scanner;

public class Q17
{

	public static void main(String[] args)
	{
		//decided to make most variables double to avoid having to type cast too much
		Scanner sc = new Scanner(System.in);
		double principal;
		double rate;
		double time;
		int total;
		
		//getting the user input
		//since these numbers are going to be integers aways I don't need to worry about parsing to a double
		System.out.print("Please enter the principal amount in thousands of dollars: ");
		principal = Integer.parseInt(sc.nextLine());
		
		//type casting the input to a double
		System.out.print("Please enter the interest rate: ");
		rate = Double.parseDouble(sc.nextLine());
		
		System.out.print("Please enter the amount of months you want to calculate the interest over: ");
		time = Integer.parseInt(sc.nextLine());
	
		//calculating the total amount and displaying it
		total = (int) ((int)principal*rate*time);
		System.out.print("The total ammount to be paid: "+total);
	}

}
