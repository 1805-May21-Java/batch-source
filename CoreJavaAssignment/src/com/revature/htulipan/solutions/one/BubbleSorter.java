package com.revature.htulipan.solutions.one;

import java.util.ArrayList;

/*
 * Q1. Perform a bubble sort on the following integer array:
 * 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
 */

public class BubbleSorter {
	private ArrayList<Integer> intList;
	private int unsortedIdx;
	
	public BubbleSorter(int[] intArray) {
		this.intList = new ArrayList<>();
		for (int i : intArray) {
			this.intList.add(i);
		}
		unsortedIdx = intList.size() - 1;
	}
	
	private void iterateOnce() {
		int maxVal = this.intList.get(0);
		int maxIdx = 0;
		for (int curIdx = 0; curIdx <= this.unsortedIdx; curIdx++) {
			int curVal = this.intList.get(curIdx);
			if (curVal > maxVal) {
				maxVal = curVal;
				maxIdx = curIdx;
			}
		}
		int temp = this.intList.get(unsortedIdx);
		this.intList.set(unsortedIdx, maxVal);
		this.intList.set(maxIdx, temp);
		unsortedIdx--;
	}
	
	public void sort() {
		printList();
		if (intList.size() < 2) {
			return;
		}
		while(unsortedIdx > -1) {
			iterateOnce();
			printList();
		}
	}
	
	public void printList() {
		for (Integer i : this.intList) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public int[] getListAsArray() {
		int[] arr = new int[intList.size()];
		for (int i = 0; i < intList.size(); i++) {
			arr[i] = intList.get(i).intValue();
		}
		return arr;
	}
}
