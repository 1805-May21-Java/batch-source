package com.revature.htulipan.solutions.one;

/*
 * Q1. Perform a bubble sort on the following integer array:
 * 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
 */

public class SolutionOneDriver {

	public static void main(String[] args) {
		int[] arrayToSort = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		BubbleSorter bs = new BubbleSorter(arrayToSort);
		bs.sort();
		int[] sortedList = bs.getListAsArray();
		System.out.println("Final Sorted Array:");
		for (int i : sortedList) {
			System.out.print(i + " ");
		}
	}
}
