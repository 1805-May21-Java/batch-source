package com.Revature.Generals;

public class Question4 {
	public static int factorial(int n) {
		if (n == 1) { //Check if n is one, base case of recursion
			return n;
		}

		return n * factorial(n - 1); //return n multiplied by n-1 and so on
	}

	public static void main(String args[]) {
		System.out.println(factorial(4));
	}
}
