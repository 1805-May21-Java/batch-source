package com.revature.scanner;

import java.util.Scanner;

public class Calculator {
	
	private static Scanner sc = new Scanner(System.in);
	
	public void calculate() {
		System.out.println("Please enter the operation you'd like to perform");
		String operation = sc.nextLine();
		
		int[] nums;
		int result;
		
		switch(operation) {
		case "addition":
			nums = getNums();
			result = nums[0]+nums[1];
			System.out.println("Your result is: "+(result));
			break;
		case "subtraction":
			nums = getNums();
			result = nums[0]-nums[1];
			System.out.println("Your result is: "+(result));
			break;
		case "division":
			nums = getNums();
			while(nums[1]==0) {
				System.out.println("Cannot divide by 0, please enter valid operands");
				nums = getNums();
			}
			result = nums[0]/nums[1];
			System.out.println("Your result is: "+(result));
			break;
		case "multiplication":
			nums = getNums();
			result = nums[0]*nums[1];
			System.out.println("Your result is: "+(result));
			break;
		default:
			System.out.println("Invalid command");
			calculate();
		}
		
	}
	
	private int[] getNums() {
		int[] nums = new int[2];
		
		System.out.println("Please enter first number:");
		nums[0] = getNum();
		
		System.out.println("Please enter second number:");
		nums[1] = getNum();
		
		return nums;
	}
	
	private int getNum() {
		int num;
		try {
			num = Integer.parseInt(sc.nextLine());
			return num;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please input an integer");
			return getNum();
		}
	}

}
