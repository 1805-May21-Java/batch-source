package com.Revature.Generals;

import java.util.ArrayList;

public class Question9 {
	public static boolean isPrime(int n) {
		if (n <= 1) { //Prime numbers start at 2
			return false;
		}
		for (int i = 2; i < n; i++) { //Exactly two divisors 1 and itself
			if ((n % i) == 0) { //If there is a positive integer divisor not prime
				return false;
			}
		}

		return true;
	}
	
	public static void printPrimes(ArrayList<Integer> numbers) {
		for ( Integer i : numbers ) { //Generic print for all primes
			if ( isPrime(i.intValue())) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for ( int i = 0; i < 100; i++ ) { //Add 0-99 to array
			arr.add(i);
		}
		
		printPrimes(arr); 
	}
}
