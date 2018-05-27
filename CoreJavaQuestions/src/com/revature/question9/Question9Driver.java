package com.revature.question9;

import java.util.ArrayList;

public class Question9Driver {

	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> strArrList1 = new ArrayList<Integer>();
		  for(int i=0;i<=100;i++) {
			  strArrList1.add(i);
			  if(isPrime(i)) {
				  System.out.println(i);
			  }
		  }
		
	}

	public static boolean isPrime(int n) {
	    for (int i = 2; i < n; i++) {
	        if (n % i == 0) {
	        	return false;
	        }
	    }
	    return true;
	}
	
}
