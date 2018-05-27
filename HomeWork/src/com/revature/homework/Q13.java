package com.revature.homework;

public class Q13 {

	public static void main(String[] args) {
		// i is row
		// j is for column

		// using nested loops
		for (int i = 1; i <= 4; i++) { // iteration on row 

			for (int j = 1; j <= i; j++) { // iteration on column until it hits the row
				System.out.print((i + j) % 2);// adding row and column then divide by 2 
				
			}
			System.out.println(); // printing extra line  to display the triangle 

		}

	}
}
