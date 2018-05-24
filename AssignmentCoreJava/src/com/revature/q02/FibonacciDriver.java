package com.revature.q02;

public class FibonacciDriver {
	public static void main(String[] args) {
		printFibFirst(25);
	}
	
	/*
	 * This function calls calcFib() for each consecutive number
	 * with a for loop. 
	 */
	static void printFibFirst(int count) {
		System.out.println("Here are the first " + count + " fibonacci numbers: ");
		for(int i = 1; i < count+1; i++) {
			System.out.print(calcFib(i) + " ");
		}
		System.out.println();
		return;
	}
	
	/* 
	 * This is a recursive function that calculates the Nth Fibonacci number
	 * the end condition is if you want the first or second numbers, which would
	 * be 0 and 1 respectively
	 */
	static int calcFib(int n) {
		if (n <= 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		return calcFib(n-1)+ calcFib(n-2);
	}
}
