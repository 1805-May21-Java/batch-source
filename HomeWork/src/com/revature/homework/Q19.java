package com.revature.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Q19 {
	public static boolean is_PrimeNumbers(int num) {
		// int count = 0;
		// for (int i = 1; i <= 10; i++) {
		// if (num % i == 0) { // checks if the number is divisible
		// count++;
		// }
		// if (count == 2) {
		// // prints prime numbers
		// } else {
		// return false;
		// }
		//
		// }
		// return true;
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

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();// creating arraylist object of Integer type
		for (int i = 1; i <= 10; i++) {// loop to iterate until 1 to 10 and stored elements
			list.add(i);// add elements in the index of arraylist
			// System.out.println(i); printing arraylist
		}
		// System.out.println(); // printing extra-line
		int EvenSum = 0;
		int SumOdd = 0;
		System.out.println(Arrays.toString(list.toArray()));// printing arraylist.
		for (int x : list) { // enhanced for loop iterate all elements in the loop
			// System.out.println(x); //display the list
			if (x % 2 == 0) // finding even numbers in the list
				EvenSum = EvenSum + x;// gives odd numbers
			// System.out.println(EvenSum);

			else // gives odd numbers
				SumOdd = SumOdd + x; // gives sum of odd numbers
			// System.out.println(SumOdd);

		}

		// System.out.println(Arrays.toString(list.toArray()));
		System.out.println("Sum of even numbers from 1 to 10 is  " + EvenSum);// display sum even
		System.out.println(" sum of odd number from 1 to 10 is " + SumOdd);// display sum odd
		//System.out.println("3 is prime: " + is_PrimeNumbers(3));
		System.out.println("removing prime numbers");
		for (int i = 1; i <= 10; i++) {

			//if (is_PrimeNumbers(i)) {
				// list.remove(i - 1);
				//for(int i = 1; i <= 10; i++) {
					if (is_PrimeNumbers(i)) {
						list.remove(new Integer(i));
					}
				}
		
		
		System.out.println(Arrays.toString(list.toArray()));
	}

}
