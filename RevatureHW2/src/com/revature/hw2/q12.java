package com.revature.hw2;

public class q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = new int [101];
		
		for(int x = 1; x <= 100; x++) {
			array[x] = x ;
		}
		
		for(int x : array) {
			if (array[x] % 2 == 0) {
				System.out.println(x);
			}
		}
	}
}