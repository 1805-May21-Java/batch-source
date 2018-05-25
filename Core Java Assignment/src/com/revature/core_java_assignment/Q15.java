package com.revature.core_java_assignment;
import java.util.Scanner;

public class Q15
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num1;
		int num2;
		
		//used a scanner to make the main method more user interactive
		System.out.println("Please input the first integer:");
		num1 = Integer.parseInt(sc.next());
		System.out.println("Please input the second integer:");
		num2 = Integer.parseInt(sc.next());
		
		//creating a object of the class to call the methods
		Q15Impl impl = new Q15Impl();
		impl.addition(num1, num2);
		impl.subtraction(num1, num2);
	}

}
