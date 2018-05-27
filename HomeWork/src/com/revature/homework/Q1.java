package com.revature.homework;

public class Q1 {
	void bubbleSort(int arr[]) {
		
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr.length - i - 1; j++)
				if (arr[j] > arr[j + 1]) { // if left side greater then right side
					// swap temp and arr[i]
					int temp = arr[j]; // assign temp variable
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	/* Prints the array */
	void printArray(int arr[]) {
		
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
		
	}

	// Driver method to test above

	public static void main(String args[]) {

		
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		Q1 ob = new Q1();

		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}

}