package com.revature.corejava.question12;

import java.util.ArrayList;

public class PrintEven {

	// ArrayList to hold the numbers
	private ArrayList<Integer> numbers=new ArrayList<Integer>();

	// Constructor that calls the super class
	public PrintEven() {
		super();
	}

	// Constructor that calls the super class and sets the private ArrayList numbers to local ArrayList numbers
	public PrintEven(ArrayList<Integer> numbers) {
		super();
		this.numbers = numbers;
	}
	
	// Constructor that calls the super class and iterates through every number between 1 and the value of last,
	// inclusively, and adds them to the ArrayList numbers
	public PrintEven(int last) {
		super();
		for(int i=1;i<=last;i++) {
			numbers.add(i);
		}
	}

	// Getter to return the ArrayList numbers
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	// Setter to set the ArrayList numbers
	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/*
	 *  Method to print out the sum of all the even numbers in the ArrayList numbers
	 *  
	 *  Enhanced for loop stores the current value from numbers into i and if i modulus two equals zero, then the
	 *  number is even, and is subsequently printed
	 *  
	 */
	public void printEvens() {
		for(Integer i:numbers) {
			if(i%2==0)
				System.out.println(i);
		}
	}
}
