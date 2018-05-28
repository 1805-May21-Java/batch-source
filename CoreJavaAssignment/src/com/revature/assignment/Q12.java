package com.revature.assignment;

public class Q12 {

	//Q12. Write a program to store numbers from 1 to 100 in an array. 
	//Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	
	int[] array = new int[101];
	
		public void evenNumbers() {
			for(int i=1; i <= 100; i++) {
				array[i] = i;
			}
			
			for(int a : array) { 
				if (a%2 == 0) {
					System.out.println(a);
				}
			}
	}
		//Driver Code
		//Q12 q = new Q12();
		//q.evenNumbers();
	
} 
