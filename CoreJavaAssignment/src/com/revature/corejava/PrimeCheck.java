package com.revature.corejava;

import java.util.ArrayList;

//Q9
public class PrimeCheck {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i=0; i<=100; i++) {
			nums.add(i);
		}
		
		System.out.println("Prime Numbers: ");
		for(int i: nums) {
			if(i!=1 && (isPrime(i) || i == 2)) {
				System.out.print(i+" ");
			}
		}
	}
	public static boolean isPrime(int n) {
		if(n%2 == 0) return false;
		for(int i=3; i<n; i+=1) {
			if(n%i==0) return false;
		}
		return true;
	}


}
