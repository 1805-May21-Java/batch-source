package com.revature.q13;

public class TriangleDriver {

	public static void main(String[] args) {
		printTriangle(4);
	}
	
	static void printTriangle(int height) {
		//start at 0
		int current = 0;
		int row = 1;
		
		//for each row
		for (int i = 0; i < height; i++) {
			//print as many numbers as there are rows
			for (int j = 0; j < row; j++) {
				System.out.print(current + " ");
				current = (current+1)%2; //alternate between 0 and 1
			}
			System.out.println();
			row++;
		}
	}
}
