package com.revature.q19;

import java.util.ArrayList;

public class ArrayListExperimentDriver {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer i = 0; i < 10; i++) {
			arr.add(i+1);
		}
		
		printEvenSum(arr);
		printOddSum(arr);
		System.out.println(arr.toString());
		removePrimes(arr);
		System.out.println(arr.toString());
		

	}
	
	static void printEvenSum(ArrayList<Integer> arr) {
		Integer sum = 0;
		
		for(Integer i : arr) {
			if(i%2 == 0) {
				sum += i;
			}
		}
		
		System.out.println("The sum of even numbers is " + sum + ".");
	}
	
	static void printOddSum(ArrayList<Integer> arr) {
		Integer sum = 0;
		
		for(Integer i : arr) {
			if(i%2 == 1) {
				sum += i;
			}
		}
		
		System.out.println("The sum of odd numbers is " + sum + ".");
	}
	
	static void removePrimes(ArrayList<Integer> arr) {
		boolean isPrime;
		int end = arr.size()-1;
		for(int index = end; index >= 0; index--) {
			isPrime = true;
			if(arr.get(index) == 1) {
				isPrime = false;
				break;
			}
			for(int number = 2; number < arr.get(index); number++) {
				if(arr.get(index)%number == 0) {
					isPrime = false;
					break;
				}
			}
			
			
			if(isPrime) {
				arr.remove(index);		
			}
		}
	}
}
