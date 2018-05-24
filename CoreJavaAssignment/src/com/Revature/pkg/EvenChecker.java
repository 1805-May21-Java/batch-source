package com.Revature.pkg;

public class EvenChecker {
	public static boolean isEven( int n ) {
		int ans = n & 1; //Bitwise and with one compares the last bit.
		//Any odd number's set of bits ends with a 1
		//0011 == 3
		//0010 == 2
		return ans == 0;
	}
}
