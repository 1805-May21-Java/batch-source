package com.revature.a2;

public class Q1BubbleSort {
	//set up the bubblesort number and needed integers
	private int[] bubbleSort = {1,0,5,6,3,2,3,7,9,8,4};
	private int change;
	private int temp;
	
	public void bubbleSort () {
		do {
			change = 0; //set change to 0 for each loop
			for (int i = 0; i < bubbleSort.length-1; i++) {
				if(bubbleSort[i] > bubbleSort[i+1]) { //if front num is greater than back num, switch them
					temp = bubbleSort[i+1];
					bubbleSort[i+1] = bubbleSort[i];
					bubbleSort[i] = temp;
					change++; //add a change counter
				}
			}
		} while (change != 0); // keep going until a run is done without any changes
		for (int j = 0; j < bubbleSort.length; j++) {
			// print out the array
			System.out.print(bubbleSort[j] + "	");
		}
		System.out.println();
	}
}
