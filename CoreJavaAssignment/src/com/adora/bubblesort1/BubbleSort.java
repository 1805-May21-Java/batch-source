package com.adora.bubblesort1;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		int length = array.length;
		
		for(int i = 0; i < length - 1; i++) {
			for(int j = 0; j < length - 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for(int a : array) {
			System.out.println(a);
		}
		
		
	}
}
