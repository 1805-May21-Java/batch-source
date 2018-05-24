package com.revature.q13;

public class TriangleDriver {

	public static void main(String[] args) {
		printTriangle(4);
	}
	
	static void printTriangle(int height) {
		int current = 0;
		int row = 1;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(current + " ");
				current = (current+1)%2;
			}
			System.out.println();
			row++;
		}
	}
}
