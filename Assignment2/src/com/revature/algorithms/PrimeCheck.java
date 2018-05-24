package com.revature.algorithms;

import java.util.ArrayList;

public class PrimeCheck {

	private ArrayList<Integer> nums;
	private ArrayList<Integer> primes;
	
	public PrimeCheck() {
		super();
		nums = new ArrayList<Integer>();
		primes = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getNums() {
		return nums;
	}

	public void setNums(ArrayList<Integer> nums) {
		this.nums = nums;
	}

	public ArrayList<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(ArrayList<Integer> primes) {
		this.primes = primes;
	}
	
	// fills nums with integers from 1 to n and primes with primes from 1 to n
	public void fillLists(int n) {
		boolean isPrime = true;
		if(n >= 1)
			nums.add(1);
		for(int i = 2; i <= n; i++) {
			isPrime = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0)
					isPrime = false;
			}
			nums.add(i);
			if(isPrime)
				primes.add(i);
		}
	}
}
