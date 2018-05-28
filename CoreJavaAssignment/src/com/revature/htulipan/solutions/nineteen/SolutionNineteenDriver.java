package com.revature.htulipan.solutions.nineteen;

import java.util.ArrayList;

import com.revature.htulipan.solutions.nine.PrimeList;

/*
 * Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */

public class SolutionNineteenDriver {
	
	public static void main(String[] args) {
		// Create an ArrayList
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// Insert integers 1 through 10
		for (int i = 1; i <= 10; i++) {
			numbers.add(i-1, i);
		}
		
		// Display the ArrayList
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		// Add all the even numbers
		int evenSum = 0;
		for (int i : numbers) {
			if (i % 2 == 0) {
				evenSum += i;
			}
		}
		
		// Display the result
		System.out.println(evenSum);
		System.out.println();
		
		// Add all the odd numbers
		int oddSum = 0;
		for (int i : numbers) {
			if (i % 2 == 1) {
				oddSum += i;
			}
		}
		
		// Display the result
		System.out.println(oddSum);
		System.out.println();
		
		// Remove all primes
		PrimeList pl = new PrimeList(10);
		ArrayList<Integer> primes = pl.getPrimes();
		
		// Must iterate backwards do avoid array out-of-bounds
		for (int i = primes.size()-1; i >= 0; i--) {
			numbers.remove(primes.get(i));
		}
		
		// Print out the remaining ArrayList
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
}
