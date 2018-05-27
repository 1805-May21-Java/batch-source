package com.adora.fibonacci2;

public class Fibonacci {

	public static void main(String[] args) {
		int prev = 0, curr = 1;
		
		System.out.println(prev);
		System.out.println(curr);
		
		for(int i = 0; i < 23; i++) {
			int f = prev + curr;
			System.out.println(f);
			
			prev = curr;
			curr = f;
			
		}

	}

}
