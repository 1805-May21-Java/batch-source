package com.revature.homework;

public class Q12 {

	public static void main(String[] args) {

		int[] values = new int[100];
		for (int i = 0; i < 100; i++) {
			values[i] = i;

		}
		for (int s : values) { // using enhanced for loop
			if (s != 0) {// don't print 0
				// System.out.print(" " +s);
				if(s%2==0) { // check prime numbers
					System.out.print(" " + s);
				}
				}

			}
		}
	}
