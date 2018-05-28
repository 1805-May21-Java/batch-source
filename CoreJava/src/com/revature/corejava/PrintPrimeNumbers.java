package com.revature.corejava;

import java.util.ArrayList;

public class PrintPrimeNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		// fill array with numbers 2 thru 100
		// (skip 1 because it's not a prime
		for (int i=2; i<=100; i++) {
			arr.add(i);
		}
		
		System.out.println("Prime numbers:");
		// iterate thru array and check for primes
		for (int num : arr) {
			if (isPrime(num)) {
				System.out.println(num);
			}
		}
		
	}
	
	// based on algorithm from https://whatis.techtarget.com/definition/prime-number
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true; // 2's only factors are 1 and itself
		}
		
		int m = (int) Math.ceil(Math.sqrt(n)); // take square root of n and round up to integer
		for (int i=m; i>=2; i--) {
			if (n % i == 0) {
				return false; // mod value of 0 means number has a factor other than 1 or itself
			}
		}
		
		return true;
	}

}
