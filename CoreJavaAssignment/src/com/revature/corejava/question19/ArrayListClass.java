package com.revature.corejava.question19;

import java.util.ArrayList;

// Imported class PrimeNumbers used in question 9
import com.revature.corejava.question9.PrimeNumbers;

public class ArrayListClass {
	
	// ArrayList to store the numbers
	private ArrayList<Integer> array;

	// Constructor that calls the super class
	public ArrayListClass() {
		super();
	}

	// Constructor that calls the super class and sets the private ArrayList array to local ArrayList array
	public ArrayListClass(ArrayList<Integer> array) {
		super();
		this.array = array;
	}
	
	// Constructor that calls the super class, instantiates array, and calls sequencalAdd method to add numbers to
	// private variable array
	public ArrayListClass(int end) {
		super();
		array=new ArrayList<Integer>();
		sequencalAdd(end);
	}

	// Getter to return ArrayList array
	public ArrayList<Integer> getArray() {
		return array;
	}

	// Setter to set private object array to local object array
	public void setArray(ArrayList<Integer> array) {
		this.array = array;
	}

	// Setter to instantiate array if it hasen't been already and then adds numbers to it using sequencalAdd method
	public void setArray(int end) {
		if(array==null)
			array=new ArrayList<Integer> ();
		else
			array.clear();
		sequencalAdd(end);
	}
	
	// Method that uses an enhanced for loop to check if each integer is an even number, and if it is, adds it to 
	// the result variable
	//
	// Returns result after for loop finishes
	public int addEvens() {
		int result=0;
		for(Integer i: array) {
			result+=(i%2==0)?i:0;
		}
		return result;
	}
	
	// Method that uses an enhanced for loop to check if each integer is an even number, and if it is not, adds it 
	// to the result variable
	//
	// Returns result after for loop finishes
	public int addOdds() {
		int result=0;
		for(Integer i: array) {
			result+=(i%2!=0)?i:0;;
		}
		return result;
	}
	
	/*
	 * Method to identify and remove prime numbers from the array variable
	 * 
	 * Creates a PrimeNumbers object and uses the array size as an argument, to create an ArrayList in the 
	 * primeNumbers object from 1 through the array size. An ArrayList is created and set to the returned value
	 * of the primeNumbers.getPrimes() method (This method returns all the prime numbers between 1 and the given
	 * array size (For more information, refer to PrimeNumbers class in com.revature.corejava.question9))
	 * 
	 * Method then loops through all the integers in the array ArrayList and checks if it exists in the primes
	 * ArrayList. If so, it is removed from the array ArrayList
	 * 
	 */
	public void removePrimes(){
		PrimeNumbers primeNumbers=new PrimeNumbers(array.size());
		ArrayList<Integer> primes=primeNumbers.getPrimes();
		
		for(int i=0;i<array.size();i++) {
			if(primes.contains(array.get(i))) {
				array.remove(i);
				i--;
			}
		}
	}
	
	// Method that adds numbers to the array ArrayList by continually adding end to the front of the ArrayList
	// and decrementing end till it reaches zero
	private void sequencalAdd(int end) {
		while(end>0) {
			array.add(0, end);
			end--;
		}
	}
}
