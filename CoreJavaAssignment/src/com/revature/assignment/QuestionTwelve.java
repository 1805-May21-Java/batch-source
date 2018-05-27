package com.revature.assignment;

public class QuestionTwelve {

	//create integer array
	static int[] intArray = new int [100];
	
	public static void main(String[] args) {
		
		//populate array with numbers 1-100
		for(int i=1; i<=100; i++) {
			intArray[i-1] = i;
		}
		
		//use enhanced for loop to display even numbers
		for(int number:intArray) {
			if(number%2 == 0) {
				System.out.println(number);
			}
		}
		
	}

}
