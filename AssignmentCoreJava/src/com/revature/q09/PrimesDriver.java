package com.revature.q09;

import java.util.ArrayList;

public class PrimesDriver {

	public static void main(String[] args) {
		
		//populate an ArrayList with the numbers 1 to 100;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int n = 1;
		while (n <= 100) {
			numbers.add(n);
			n++;
		}
		
		System.out.println("Primes between 1 and 100: ");
		printPrimes(numbers);
		System.out.println();
	}
	
	static void printPrimes(ArrayList<Integer> list) {
		boolean isPrime;
		for(Integer num : list) {
			//prime until proven composite
			isPrime = true;
			/*
			 * similar to the palindrome test, we check if each number is 
			 * divisible by any number before it
			 */
			for (int i = 2; i < num; i++) {
				if(num%i == 0) {
					isPrime = false;
					break;
				}
			}
			
			//one is not a prime number
			if( num == 1) {
				isPrime = false;
			}
			
			
			//Print prime
			if(isPrime) {
				System.out.print(num + " ");
			}
		}
	}

}
