package com.revature.homework;

import java.util.ArrayList;

public class Q9 {
	/*
	public static boolean is_PrimeNumbers(int num) {
	boolean isPrime = true;
	int temp;
	for (int i = 2; i <= num / 2; i++) {
		temp = num % i;
		if (temp == 0) {
			isPrime = false;
			break;
		}
	}
	return isPrime;
	}
*/
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i<=100; i++) {
			list.add(i);
			  //System.out.println(list.get(i-1));
		}
		//int count =0;
		for(int x : list) {
			int count =0;
				//System.out.println(x); //prints number from 1 to 100;
		
			 for(int j = 2; j<x;j++) {
				 if(x%j==0) {
					count++;
					break;
				 }
			 } if(count ==0) { // provides primenumbers 
				if(x!=1) //1 is not a prime numbers
				 System.out.println(x);
				 
			 }
		 }
		}  
		 
		
		
			
			
	

}
