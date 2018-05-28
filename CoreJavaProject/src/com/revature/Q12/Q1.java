package com.revature.Q12;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		int temp;
		//Gets size of array to find upper bound
		int size = arr.length;
		//Moves through each instance of the array until it is entirely sorted
		for(int i=0;i<size -1;i++) {
			//Swaps out each value for the one in front of it if it is lesser than it
			for(int j=1; j < size-i;j++) {
				if(arr[j-1] > arr[j]) {
					//Swaps out temp with arr[j]
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
			//Prints array for confirmation
			System.out.print(Arrays.toString(arr));
	}

}
