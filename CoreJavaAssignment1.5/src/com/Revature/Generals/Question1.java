package com.Revature.Generals;

public class Question1 {
	public static void main(String[] args) {
		//Define Array of ints
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		//Save length
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) { //Iterate over arr
			//Only need n-1 iteration as nth iteration the list will be sorted
			for (int j = 0; j < n - i - 1; j++) {
				//Iterate from 0 until the index in which 
				//the list is sorted
				if ( arr[j] > arr[j+1]) {
					//Compares current val with val next to it
					//If need be, swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for ( int i:arr) { //Output sorted array
			System.out.print(i+" ");
		}
	}
}
