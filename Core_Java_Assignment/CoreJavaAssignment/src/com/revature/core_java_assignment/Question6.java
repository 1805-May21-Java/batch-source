package com.revature.core_java_assignment;

public class Question6 {
	
	public static boolean isEven(int num) {
		// 5 / 2 = 2, since java truncates the decimal due to integer division.
		// 2 * 2 != 5. This is the case for every odd number.
		int quotient = num / 2;
		return quotient * 2 == num;
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(7));
		System.out.println(isEven(10));
	}
}
