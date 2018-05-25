package com.revature.a2;

import java.util.ArrayList;

public class Q9PrimeNumber {
	
	//set up arraylist, and array
	private ArrayList<Integer> numlist = new ArrayList<Integer>();
	private int[] primelist = new int[100];
	private int z = 1;
	private boolean isPrime = true;
	
	public void primeNumber() {
		for(int i = 0; i < 100; i++) {
			//add 1 to 100 to the arraylist
			numlist.add(i+1);
		}
		
		//add 2 as it is definately a prime
		primelist[0] = 2;
		for(int j = 2; j < 100; j++) {
			//starts from 3 as 2 is already a prime and entered, and 1 and 0 are definately not prime
			for (int l = 1; l < j; l++) {
				//find if prime by seeing if there is a reminder for every num from 2 to num tested - 1, if none of the 
				//reminder are 0, then it is a prime
				if(numlist.get(j)%numlist.get(l) == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				//add the prime numbers in the array
				primelist[z] = numlist.get(j);
				z++;
			}
			//set it back to true for next num
			isPrime = true;
		}
		
		//print them out
		System.out.print("The prime numbers are:  ");
		for(int m = 0; m < z; m++) {
			System.out.print(primelist[m] + "  ");
		}
	}
}
