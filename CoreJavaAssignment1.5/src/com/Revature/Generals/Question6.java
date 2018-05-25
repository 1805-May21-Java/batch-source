package com.Revature.Generals;

public class Question6 {
	public static boolean isEven(int n) {
		return (n & 1) == 0;
		//Bitwise operator and with 1
		//Checks the last bit of n to see if there is a 1 or not
	}

	public static void main(String args[]) {
		System.out.println(isEven(2));
		System.out.println(isEven(13));
	}
}
