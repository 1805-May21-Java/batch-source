package com.revature.q04;

public class FactorialDriver {

	public static void main(String[] args) {
		long n = 14;
		System.out.print(n + "! = ");
		System.out.println(factorial(n));
	}
	
	/*
	 * This is another recursive function that multiplies n to the factorial
	 * of the consecutive number before it.
	 * 
	 * There is a limit though, even though it uses a long, at some point this
	 * will return the wrong answer because the number will overflow
	 */
	static long factorial(long n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n-1);
	}

}
