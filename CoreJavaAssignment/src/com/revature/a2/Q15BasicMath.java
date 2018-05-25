package com.revature.a2;

import java.util.Scanner;

public class Q15BasicMath implements Q15Interface{
	
	Scanner scan = new Scanner(System.in);
	public void calculation(int a, int b) {
		System.out.println("Please enter the operation you'd like to perform");
		String operation = scan.nextLine();
		
		//choose which operation to use then move to the appropriate function
		switch(operation){
			case "addition":
				System.out.println("Your result is: " + addition(a,b));
				break;
			case "subtraction":
				System.out.println("Your result is: " + subtraction(a,b));
				break;
			case "multiplication":
				System.out.println("Your result is: " + multiplication(a,b));
				break;
			case "division":
				System.out.println("Your result is: " + division(a,b));
				break;
			default:
				//breaks the whole program when entered invalid command
				System.out.println("Invalid Command");
				break;
		}
	}

	//Override the 4 methods from the interface to do the actual work here
	@Override
	public int addition(int a, int b) {
		
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		if(b != 0) {
			return a / b;
		}
		System.out.println("You can not enter 0 for division!");
		return 0;
	}

	
}
