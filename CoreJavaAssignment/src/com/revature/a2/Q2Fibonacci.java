package com.revature.a2;

public class Q2Fibonacci {
	// set up the numbers needed for fibonacci
	private int currentNum = 0;
	private int nextNum = 1;
	private int result;

	public void fibonacci() {
		// the loop needed to get each number out until 25th one
		for (int i = 0; i < 25; i++) {
			//0 and 1 are special as they don't follow fibonacci rules yet
			if (i == 0) {
				result = currentNum;
			}
			//moving the numbers done the line as the next number is always the sum of 2 previosu numbers
			else if (i == 1) {
				result = nextNum;
				currentNum = nextNum;
				nextNum = result;
			}
			else {
				result = currentNum + nextNum;
				currentNum = nextNum;
				nextNum = result;
			}
			// print out the numbers 1 sequence at a time
			System.out.print(result + "  ");
		}
		System.out.println();
	}
}
