package com.Revature.pkg;

public class BubbleSortDriver {
	public static int[] bubbleSort(int[] arr) {
		// Get size of array
		int n = arr.length;

		// Iterate over the list from 0 to n-1
		// The n-th iteration is unnecessary as array will be sorted

		for (int i = 0; i < n - 1; i++) {
			// Iterate from 0 to n-i-1
			// This will take the first number and compare it to the second
			// If the first number is greater, the numbers are swapped
			// Otherwise, the first number is in the correct position
			// In reference to the second number
			// Then the second number is the one that is compared onward
			// Loop goes to n-i-1 because the array is being sorted
			// Back to front

			for (int j = 0; j < n - i - 1; j++) {
				// Compare arr[j] and arr[j+1]
				if (arr[j] > arr[j + 1]) {
					// Sway the two values
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.print("[");
		for (int i : arr) {
			System.out.print(" " + i + " ");
		}
		System.out.println(']');

		return arr;
	}
}
