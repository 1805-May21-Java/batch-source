package com.revature.q1;

public class Driver {

	public static void main(String[] args) {
		BubbleSorter bs = new BubbleSorter();
		int[] newArr = {1,0,5,6,3,2,3,7,9,8,4};
		bs.bubbleSort(newArr);
		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}
			
	}
	
}
