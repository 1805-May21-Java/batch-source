package com.revature.Q12;

import java.util.Scanner;

public class Q4 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner to accept the number you want to find the factorial of
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in the number you want to find the factorial of: ");
		int n=sc.nextInt();
		//First number in the factorial is always 1
		int result =1;
		//Loop through until the max(n) is reached
		for(int i=1; i<=n;i++) {
			result =result*i;
		}
		//Prints result and the number you originally entered
		System.out.println("The factorial of "+n+ " is: "+result);
	}

}
