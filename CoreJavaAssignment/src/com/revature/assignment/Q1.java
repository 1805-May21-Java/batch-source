package com.revature.assignment;

public class Q1 {

	public static void main(String[] args) {

	//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	
		int[] unsortedArr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
			//For loop running through each value and comparing it to others then moving it to sorted position
			for(int i = 0; i < unsortedArr.length; i++) {
				for(int j = 0; j < unsortedArr.length; j++) {
					if(unsortedArr[i] < unsortedArr[j]) {
						int temp = unsortedArr[i];
						unsortedArr[i] = unsortedArr[j];
						unsortedArr[j] = temp;
					}
				}
			//Printing out array
			} for(int i = 0; i < unsortedArr.length; i++) {
		        System.out.print(unsortedArr[i] + " ");
		    }
	
	}
}

