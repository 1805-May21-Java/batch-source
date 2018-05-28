package com.revature.q2;

public class Driver {

	public static void main(String[] args) {

		int f = 0;
		int n = 1;
		for(int i = 0; i < 25; i++) {
			
			System.out.println(f);
			int sum = f+n;
			f = n;
			n = sum;

		}

	}

}
