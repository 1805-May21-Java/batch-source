package com.revature.homework;

public class Q4 {
	
	
	
public	int factorial( int N )

	{

	if ( N == 0 || N == 1 ) { // checks the condition for 1 or 0, and returns one if use input those

	return 1;
	}
	return N * factorial( N -1 ); // otherwise return this computation.

	}

	public static void main(String[] args) {
		Q4 F = new Q4();
		System.out.println(F.factorial(0));

}
}