package com.revature.corejava.question4;

public class FactorialDriver {

	public static void main(String[] args) {
		
		// Create a new Factorial object and sets the n variable value to 1
		Factorial fact=new Factorial(1);
		
		// Check that the returned value is 1
		System.out.println("1 Factorial");
		System.out.println(fact.getN());
		System.out.println();
		
		// Set the value of n to 2
		fact.setN(2);
		
		//Check that the returned value is 2
		System.out.println("2 Factorial");
		System.out.println(fact.getN());
		System.out.println();
		
		
		// Set the value of n to 3
		fact.setN(3);
		
		// Check that the returned value is 6
		System.out.println("3 Factorial");
		System.out.println(fact.getN());
		System.out.println();
		
		// Set the value of n to 4
		fact.setN(4);
		
		// Check that the returned value is 24
		System.out.println("4 Factorial");
		System.out.println(fact.getN());
		System.out.println();
		
		// Set the value of n to 5
		fact.setN(5);
		
		// Check that the returned value is 120
		System.out.println("5 Factorial");
		System.out.println(fact.getN());
		System.out.println();

	}

}
