package com.Revature.Question15pkg;

public class MathDriver {
	public static void main(String args[]) {
		NewNewMath m = new NewNewMath(); //Instantiate math object
		
		int n1 = 10 , n2 = 5; //Define operands
		
		System.out.println(m.add(10, 5)); //Test all methods
		System.out.println(m.subtract(n1, n2));
		System.out.println(m.multiply(n1, n2));
		System.out.println(m.divide(n1, n2));
	}
}
