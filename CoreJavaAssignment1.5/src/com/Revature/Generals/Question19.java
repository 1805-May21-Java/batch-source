package com.Revature.Generals;

import java.util.ArrayList;

public class Question19 {
	public static int addEvens(ArrayList<Integer> iList) {
		int sum = 0;
		for (Integer i : iList) {
			if (i % 2 == 0) { //Check if i is even
				sum += i; //Add even numbers to sum
			}
		}
		return sum;
	}

	public static int addOdds(ArrayList<Integer> iList) {
		int sum = 0;
		for (Integer i : iList) {
			if (i % 2 == 1) { //Check if i is odd
				sum += i; //Add odd numbers to sum
			}
		}

		return sum;
	}

	public static boolean isPrime(Integer i) {
		//Some debate on whether 1 is prime or not
		for (int n = 2; n < i; n++) { //Determine if i is prime
			if (i % n == 0) {
				return false;
			}
		}

		return true;
	}

	public static void removePrimes(ArrayList<Integer> iList) {
		int i = 0;
		while (i < iList.size()) {
			if (isPrime(iList.get(i))) { //If number is prime remove it
				//Remove an element shrinks the list, meaning incrementing i is unnecessary
				iList.remove(i);
			} else {
				i++; //If number is not removed, iterate to next element.
			}
		}
	}

	public static void printArray(ArrayList<Integer> iList) {
		System.out.print("[ "); //Print the array
		for (Integer i : iList) {
			System.out.print(i+" ");
		}
		System.out.println("]");
	}

	public static void main(String args[]) {
		ArrayList<Integer> iList = new ArrayList<Integer>(); //Instantiate array list

		for (int i = 1; i < 11; i++) { //Add 1-10 to the array
			iList.add(i);
		}
		
		printArray(iList); //Print array

		//Print the summations of all even numbers
		System.out.println("The sum of all even numbers is " + addEvens(iList)); 

		//Print summation of all odds
		System.out.println("The sum of all odd numbers is " + addOdds(iList));

		//Remove primes from list
		removePrimes(iList);

		//Print result
		System.out.println("Array List without primes:");
		printArray(iList);
	}
}
