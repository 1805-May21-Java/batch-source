package com.adora.primes9;

import java.util.ArrayList;

public class Primes {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			list.add(i);
		}
			
		for(int a: list) {
			System.out.print((isPrime(a))? a + ", ": "");
		}
	}
	
	public static boolean isPrime(int n) {
		
		if(n == 1 || n == 2) {
			return true;
		}
		for(int i = 2; 2 * i <= n; i++) {
			if(n % i == 0)
				return false;
		}
		
		return true;
	}

}
