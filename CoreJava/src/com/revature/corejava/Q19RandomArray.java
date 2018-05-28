package com.revature.corejava;

import java.util.ArrayList;

public class Q19RandomArray {

	public static void main(String[] args) {
		
		// populate array
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=1; i<=10; i++) {
			arr.add(i);
		}
		
		int evenSum = 0;
		int oddSum = 0;
		ArrayList<Integer> nonPrimes = new ArrayList<Integer>();
		
		for (int num : arr) {
			if (num % 2 == 0) {
				evenSum += num; // even number, add to sum
			} else {
				oddSum += num; // odd number, add to sum
			}
			
			// check for primes using method from Q09PrintPrimeNumbers
			if (!Q09PrintPrimeNumbers.isPrime(num)) {
				nonPrimes.add(num);
			}
		}
		
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		System.out.println("Non-prime numbers: " + nonPrimes);

	}

}
