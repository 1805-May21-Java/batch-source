package com.revature.q01;

import java.util.Arrays;

public class BubbleSortDriver {

	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("The starting array is " + Arrays.toString(arr));
		
		arr = bubbleSort(arr);
		
		System.out.println("The sorted array is " + Arrays.toString(arr));

	}
	
	public static int[] bubbleSort(int[] arr) {
		//I'm not entirely sure if I work on arr that I'll end up editing arr
		//working in C++ has had me wary of accidentally working on the parameters themselves
		int[] sortedArr = arr;
		//This is a flag to indicate if a change has been made to the array
		boolean hasShifted;
		
		
		/*
		 * In theory this bubble sort runs at O(N^2)
		 * It passes through the array completely and then if a change is made, it 
		 * goes for another pass. Lower numbers float up. Worst case would be if 
		 * the smallest number was on the bottom since it would need to go through the 
		 * array as many times as there are elements
		 */
		do {
			//reset flag
			hasShifted = false;
			for (int i = 0; i < sortedArr.length-1; i++) {
				if (sortedArr[i] > sortedArr[i+1]) {
					int temp = sortedArr[i];
					sortedArr[i] = sortedArr[i+1];
					sortedArr[i+1] = temp;
					//set flag since two elements have switched
					hasShifted = true;
				}
			}
		} while(hasShifted);
		
		
		//Array is sorted! Send it!
		return sortedArr;
	}
	
	
}
