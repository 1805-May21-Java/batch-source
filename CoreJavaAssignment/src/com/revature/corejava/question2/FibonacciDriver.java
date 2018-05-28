package com.revature.corejava.question2;

public class FibonacciDriver {

	public static void main(String[] args) {
		
		// New Fibonacci object with the test number
		Fibonacci fib=new Fibonacci(25);
		
		// Prints the result, which should be 75025
		System.out.println(fib.getResult());
		

	}

}
