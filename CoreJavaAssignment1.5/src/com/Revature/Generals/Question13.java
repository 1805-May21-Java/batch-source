package com.Revature.Generals;

public class Question13 {
	public static void printRow(int row) {
		//i goes 0 to row +1 as row will start at 0
		//At row 0 at least one element
		for (int i = 0; i < row + 1; i++) {
			//(row+i) % 2 means for each odd numbered row
			//start digit is 1
			//start of row, i == 0
			System.out.print((row + i) % 2 + " ");
		}
	}

	public static void main(String args[]) {
		for (int i = 0; i < 4; i++) { //Print four rows
			printRow(i);
			System.out.println();
		}
	}

}
