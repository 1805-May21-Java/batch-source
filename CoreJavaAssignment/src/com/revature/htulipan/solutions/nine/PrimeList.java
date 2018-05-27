package com.revature.htulipan.solutions.nine;

import java.util.ArrayList;

public class PrimeList extends ArrayList<Integer> {
	private static final long serialVersionUID = -5679538347853999525L;
	
	private int max;
	private ArrayList<Integer> nums;
	private ArrayList<Integer> primes;
	
	public PrimeList() {
		super();
	}

	public PrimeList(int max) {
		super();
		
		this.max = max;
		this.nums = new ArrayList<>();
		
		if (max < 2) {
			this.primes = new ArrayList<>();
		} else {
			for (int i = 1; i <= max; i++) {
				nums.add(i);
			}
			findPrimes();
		}
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
		this.nums = new ArrayList<>();
		
		if (max < 2) {
			this.primes = new ArrayList<>();
		} else {
			for (int i = 1; i <= max; i++) {
				nums.add(i);
			}
			findPrimes();
		}
	}

	public ArrayList<Integer> getNums() {
		return nums;
	}

	public ArrayList<Integer> getPrimes() {
		return primes;
	}
	
	// Implement Sieve of Eratosthenes
	private void findPrimes() {
		this.primes = new ArrayList<>();
		
		ArrayList<Boolean> primeList = new ArrayList<>();
		primeList.add(0, false);
		primeList.add(1, false);
		for (int i = 2; i <= max; i++) {
			primeList.add(i, true);
		}
		
		for (int i = 2; i <= max; i++) {
			if (primeList.get(i)) {
				primes.add(i);
				for (int j = i+1; j <= max; j++) {
					if (primeList.get(j) && (j % i == 0)) primeList.set(j, false);
				}
			}
		}
	}
	
	public void printPrimes() {
		for (Integer i : primes) {
			System.out.println(i);
		}
	}
}
