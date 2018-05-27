package com.revature.assignment;

import java.util.ArrayList;

public class QuestionNine {
		
	//method to check if a number is a prime number
	//divides it by every number smaller to see if there is no remainder
	public static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i=1; i<=100; i++) {
			intList.add(i);
		}
		
		System.out.println("The prime numbers from 1 to 100 are:");
		for(int i = 1; i<intList.size(); i++) {
			if(isPrime(intList.get(i))) {
				System.out.print(intList.get(i)+" ");
			}
		}
	}
}
