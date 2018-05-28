package com.revature.assignment;

import java.util.ArrayList;

public class Q9 {

	//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	
	public void optimusPrime() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> primeArray = new ArrayList<Integer>();
		for(int i = 0; i <= 100; i++) {
			array.add(i);
		}
		System.out.println(array);
		for(int i=1; i<array.size(); i++){
	        for (int j=2; j<array.get(i); j++){
	            if(array.get(i)%j == 0){
	                array.remove(i);
	            } 
	        } if ( i == 30) {
	        	break;
	        }
		}
		System.out.println("Prime numbers: " +array.toString());
	}
	
//			Driver Code
//			Q9 q = new Q9();
//			q.optimusPrime();
	
}
