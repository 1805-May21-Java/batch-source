package com.revature.q19;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		ArrayList<Integer> myList = new ArrayList<Integer>();
		ArrayList<Integer> myEvens = new ArrayList<Integer>();
		ArrayList<Integer> myOdds = new ArrayList<Integer>();
		// creates a list of integers 1-10
		for (int i = 1; i < 11; i++) {
			myList.add(i);
		}
		
		// prints each number in the array one at a time
		System.out.println("All numbers in myList:");
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		for (int num : myList) {
			// checks if even
			if (num % 2 == 0){
				// if even, adds to myEvens
				myEvens.add(num);
			} else {
				// else, adds to myOdds
				myOdds.add(num);
			}
		}
		int evenSum = 0;
		for (int x : myEvens) {
			evenSum += x;
			
		}System.out.println("Sum of evens:" + evenSum);
		
		int oddSum = 0;
		for(int y : myOdds) {
			oddSum += y;
		} System.out.println("Sum of odds:" + oddSum);
		
		for (int i = 0; i < myList.size(); i++) {
			for (int j = 2; j < i; j++) {
				if (i % j != 0) {
					myList.remove(i);
				}
			}
		} System.out.println("Prime numbers:" + myList.toString());
	}
	
}

