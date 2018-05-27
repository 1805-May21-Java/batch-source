package com.revature.assignment;

public class QuestionTwo {
	
	
	public static void main(String[] args) {
		//initializing variables
		int num = 25;
		int a, b, c;
		a=0;
		b=1;
		c=2;
		
		System.out.println("The first " + num + " Fibonnaci numbers are:");
		
		//loops through each number between 1 and 25
		// adds the two previous numbers, then changes a and b to the next two numbers
		for(int i=1; i<=num; i++) {
			c = a+b;
			System.out.print(a + " ");
			a=b;
			b=c;
		}
	}

}
