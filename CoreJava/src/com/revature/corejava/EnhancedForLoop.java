package com.revature.corejava;

public class EnhancedForLoop {

	public static void main(String[] args) {
		
		// populate array of numbers
		int[] arr = new int[100];
		for (int i=0; i<100; i++) {
			arr[i] = i + 1;
		}
		
		System.out.println("Even numbers:");
		for (int num : arr) { // enhanced for loop
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}

	}

}
