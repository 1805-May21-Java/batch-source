package com.revature.core_java_assignment;
import java.util.Scanner;

public class Q6
{

	public static void main(String[] args)
	{
		//declaring a scanner to take an integer N
		Scanner sc = new Scanner(System.in);
		int result;
		int isEven;
		
		//while not specified in the assignment I thought it was in the spirit of the assignment to have it 
		//take any integer not just one that I predetermined
		System.out.println("Please enter the integer you would like to check: ");
		int num = Integer.parseInt(sc.nextLine());
		
		//if you divide a number by 2 and then take that result and multiply it by 2
		//if it is even you will get the number that you started with
		//if it is odd it wont be
		result = num / 2;
		isEven = result * 2;
		
		if(isEven != num)
		{
			System.out.println("Number is odd");
		}
		else if (isEven == num)
		{
			System.out.println("Number is even");
		}
	}

}
