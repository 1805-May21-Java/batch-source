package com.revature.algorithms;

public class BubbleSort {

	public BubbleSort() {
		super();
	}

	// Takes int array arr and applies the BubbleSort algorithm
	public static int[] bubbleSort(int[] arr) {
		int[] arrToSort = arr;
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < arrToSort.length - 1; i++) {
				// Compares adjacent terms and switches them if they are unsorted
				if(arrToSort[i] > arrToSort[i + 1]) {
					sorted = false;
					int temp = arrToSort[i];
					arrToSort[i] = arrToSort[i + 1];
					arrToSort[i + 1] = temp;
				}
			}
		}
		return arrToSort;
	}
}
