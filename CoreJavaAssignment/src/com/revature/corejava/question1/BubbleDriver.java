package com.revature.corejava.question1;

public class BubbleDriver {

	public static void main(String[] args) {
		// Set up new BubbleSort object with the test sequence
		BubbleSort bs=new BubbleSort(new int[] {1,0,5,6,3,2,3,7,9,8,4});
		
		// Get the sorted array
		int[] sortedNumbers=bs.getNumbers();
		
		// Print out the array
		for(int num:sortedNumbers) {
			System.out.print(num+" ");
		}

	}

}
