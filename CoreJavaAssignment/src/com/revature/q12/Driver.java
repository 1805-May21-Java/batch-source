package com.revature.q12;

public class Driver {

	public static void main(String[] args) {
		
		// creates array myArr that has 100 indices
		int[] myArr;
		myArr = new int[100];
		// loops through each index of myArr and sets the value of the index to index + 1, 
		// making each value 1-100 at the indices 0-99 
		for (int i = 0; i < 100; i++) {
			myArr[i] = i + 1;
		}
		// enhanced for loop to iterate through each num in myArr
		for (int num : myArr) {
			// checks if even
			if (num % 2 == 0){
				// if so, prints to console
				System.out.println(num);
			}
			
		}
		
	}

}
