package com.revature.algorithms;

public class Triangle {

	public Triangle() {
		super();
	}

	// prints a binary triangle of given height, similar to the example in the homework with height 4
	public static void printBinaryTriangle(int height) {
		for(int i = 1; i <= height; i++) {
			for(int j = 0; j < i; j++) {
				int val = Math.round((float)(0.5 + 0.5 * Math.pow(-1, i + j)));
				System.out.print(val);
				if(j != i - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
