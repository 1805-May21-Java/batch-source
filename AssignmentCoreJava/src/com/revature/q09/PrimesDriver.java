package com.revature.q09;

import java.util.ArrayList;

public class PrimesDriver {

	public static void main(String[] args) {
		
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
			isPrime = true;
			for (int i = 2; i < num; i++) {
				if(num%i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if( num == 1) {
				isPrime = false;
			}
			
			if(isPrime) {
				System.out.print(num + " ");
			}
		}
	}

}
