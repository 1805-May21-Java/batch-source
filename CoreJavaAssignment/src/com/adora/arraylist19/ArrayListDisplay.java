package com.adora.arraylist19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDisplay {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		Iterator<Integer> it = list.iterator();

		int evenSum = 0;
		int oddSum = 0;
		while(it.hasNext()) {
			int num = (it.next());
			
			if(num % 2 == 0)
				evenSum += num;
			else
				oddSum += num;
			
			if(com.adora.primes9.Primes.isPrime(num)) {
				it.remove();
			}
			
		}
		
		System.out.println("Sum of evens: " + evenSum);
		System.out.println("Sum of odds: " + oddSum);
		System.out.println(list.toString());

	}
	
	

}
