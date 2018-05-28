package com.revature.htulipan.solutions.thirteen;

/*
 * Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    0 1 0
    1 0 1 0
 */

public class SolutionThirteenDriver {
	
	public static void main(String[] args) {
		
		int n = 4;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				int num = i + j;
				if ((1 & num) == 1) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1 + " ");
				}
			}
			System.out.print("\n");
		}
	}
}
