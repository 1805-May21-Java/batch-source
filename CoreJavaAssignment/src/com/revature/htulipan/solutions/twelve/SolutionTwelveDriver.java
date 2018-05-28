package com.revature.htulipan.solutions.twelve;

/*
 * Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */

public class SolutionTwelveDriver {

	public static void main(String[] args) {
		int[] nums = new int[100];
		
		for (int i = 0; i < 100; i++) {
			nums[i] = i+1;
		}
		
		for (int i : nums) {
			if ((1 & i) == 0) {
				System.out.println(i);
			}
		}
	}
}
