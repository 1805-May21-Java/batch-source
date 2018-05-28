package com.revature.Q12;

import java.util.*;

public class Q19 {

	public static void main(String[] args) {
		//Create ArrayList called List
		ArrayList<Integer> List = new ArrayList<Integer>();
		//Added integers 1-10
		List.add(1);
		List.add(2);
		List.add(3);
		List.add(4);
		List.add(5);
		List.add(6);
		List.add(7);
		List.add(8);
		List.add(9);
		List.add(10);
		//Displayed List
		System.out.println(List);
		int even=0;
		int odd=0;
		//For loop to find even and odd numbers, and totals
		for(int n:List) {
			if(n % 2 ==0) {
				even+=n;
			}
			else {
				odd+=n;
			}
		}
		//Print out totals of both even and odds
		System.out.println(even);
		System.out.println(odd);
		//for loop to remove Prime numbers
		for(int i =1;i<=10;i++) {
			//Calls function then removes number at that index if prime
			if(Prime(i)) {
				List.remove(new Integer(i));
			}
		}
		System.out.println(List);
	}
	
	static boolean Prime(int n) {
		if(n==2) {
			return true;
		}
		int a = 0;
		int b = 0;
		b = n/2;
		//For loop to navigate through List
		for(a=2;a<=b;a++) {
			if(n%a == 0) {
				return false;
			}
		}
		return true;
		
	}
}
