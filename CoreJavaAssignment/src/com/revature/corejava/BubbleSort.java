package com.revature.corejava;
//Q1
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j]= array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i: array) {
			System.out.print(i+" ");
		}
	}

}
