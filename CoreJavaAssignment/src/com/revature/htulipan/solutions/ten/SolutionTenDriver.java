package com.revature.htulipan.solutions.ten;

/*
 * Q10. Find the minimum of two numbers using ternary operators.
 */

public class SolutionTenDriver {

	public static void main(String[] args) {
		int[] pairs = {2, 7, -2, -9, 5, 34, 123, 52, 65, 84, -56, 90, 32, 41};
		
		for (int i = 0; i < pairs.length; i += 2) {
			int first = pairs[i];
			int second = pairs [i+1];
			System.out.println("Minimum of " + first + " and " + second + ":");
			System.out.println(findMin(first, second));
		}
	}
	
	public static int findMin(int first, int second) {
		return (first <= second) ? first : second;
	}
}
