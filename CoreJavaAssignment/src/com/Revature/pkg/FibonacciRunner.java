package com.Revature.pkg;

public class FibonacciRunner {
	public static void getFib(int n) {
		int[] arr = { 0, 1 }; // Define first two numbers in sequence

		System.out.print(arr[0] + " " + arr[1] + " ");
		
		//Run loop n - 2 times as first two numbers will be printed
		for (int i = 0; i < n - 2; i++) {
			int res = arr[0]+arr[1]; //Calculates next value
			System.out.print(res+" "); //Outputs next val
			arr[0] = arr[1]; //Swaps second val to the first and the result to the second
			arr[1] = res;
		}
	}
}
