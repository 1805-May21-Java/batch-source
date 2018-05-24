package com.Revature.pkg;

public class FactorialDriver {
	public static int factorial( int n ) {
		if ( n == 1 ) { //Final case of recursion
			return n;
		}
		
		return n * factorial(n - 1 ); //Return the number multiplied by n - 1
	}
}
