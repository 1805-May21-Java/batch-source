package com.revature.q10;

public class TernaryDriver {

	public static void main(String[] args) {
		int a = 30;
		int b = 45;
		System.out.println("Between " + a + " & " + b + ", the minimum is " + minimum(a, b) + ".");
	}
	
	static int minimum(int a, int b) {
		//if a is less than b, return a, else return b
		return (a < b) ? a : b;
	}

}
