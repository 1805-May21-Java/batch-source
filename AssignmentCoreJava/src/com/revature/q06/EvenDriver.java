package com.revature.q06;

public class EvenDriver {

	public static void main(String[] args) {
		System.out.println("5 is even: " + isEven(5));
		System.out.println("30 is even: " + isEven(30));
		System.out.println("77 is even: " + isEven(77));
		System.out.println("987 is even: " + isEven(987));
	}
	
	/*
	 * With the way that integers work, dividing an odd number by two will round down
	 * to the next integer. In doubling a halved odd integer, you come one short from
	 * the original number. Even numbers don't have this problem
	 */
	static boolean isEven(int num) {
		int half = num/2;
		if(half * 2 == num) {
			return true;
		}
		return false;
	}
}
