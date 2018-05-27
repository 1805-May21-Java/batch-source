package com.revature.assignment;

import java.util.ArrayList;

public class QuestionNineteen {

	//method that checks if a number is prime to be used later
	public static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		//creates ArrayList and adds integers between 1 and 10
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			intList.add(i);
		}
		
		//prints out the numbers in the ArrayList
		System.out.println("The numbers in the ArrayList are:");
		for(Integer i:intList) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();

		//adds to even total if num mod 2 = 0, else adds to the odd total
		int evenTotal = 0;
		int oddTotal = 0;
		for(int i=0; i<intList.size(); i++) {
			if(intList.get(i) % 2 == 0) {
				evenTotal += intList.get(i);
			}else {
				oddTotal += intList.get(i);
			}
		}
		System.out.println("The sum of the even numbers in the ArrayList is:");
		System.out.println(evenTotal);
		System.out.println();
		
		System.out.println("The sum of the odd numbers in the ArrayList is:");
		System.out.println(oddTotal);
		System.out.println();
		
		//calls isPrime method and removes if they are prime
		for(int i=0; i<intList.size(); i++) {
			if(isPrime(intList.get(i)) == true) {
				intList.remove(i);
			}
		}
		System.out.println("The numbers in the ArrayList after removing primes are:");
		for(Integer i:intList) {
			System.out.print(i + " ");
		}
	}
}