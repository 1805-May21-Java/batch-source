package com.revature.assignment;

public class QuestionFour {
	
	private static int num = 10;
	private static long numFactorial = 1;
	
	public static void main(String[] args) {
		
		//loops through each number below the given num
		for(int i=num; i>0; i--) {
			
			//multiplies i to the end result, creating the factorial
			numFactorial *= i;
		}
		
		System.out.println("The factorial of "+num+" is:");
		System.out.println(numFactorial);
		
	}

}
