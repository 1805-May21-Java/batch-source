package com.revature.corejava.question9;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {

	// Initializes a scanner to be used to get input from the console and an ArrayList to store the integers
	private Scanner sc=new Scanner(System.in);
	private ArrayList<Integer> array=new ArrayList<Integer>();

	// Constructor to make a new PrimeNumbers object that calls the super class
	public PrimeNumbers() {
		super();
	}

	// Constructor to make a new PrimeNumbers object that calls the super class and adds Integers to the array
	// ArrayList, starting at 1 and going up till the value of the lastNumber variable
	public PrimeNumbers(int lastNumber) {
		super();
		for(int i=0;i<lastNumber;i++) {
			array.add(i+1);
		}
	}
	
	// Method to print out all the primes in the array ArrayList by calling the getPrimes method which returns
	// them in an ArrayList
	public void printPrimes() {
		getPrimes().forEach((prime)->System.out.println(prime));
	}
	
	/*
	 * Method to determine which numbers in the array ArrayList are primes and return them in their own ArrayList
	 * 
	 * First, initializes a new ArrayList called primes to store all the prime numbers and adds the number 2 to 
	 * the list (the first prime number)
	 * 
	 * Next, a for loop is run that iterates through every other number in the ArrayList array starting at the number
	 * 3 (effectively skipping all the even numbers) 
	 * 
	 * In the loop, a int variable (testVar) is initialized to the square root of the current integer from array
	 * 
	 * An int variable, counter, is initialized to 0, an int variable, prime, is initialized to the value of the 
	 * first number in the prime ArrayList, and a boolean variable, divisible, is initialized to false
	 * 
	 * Next, a whlie loop is used that continues while the variable prime is less than testVar. 
	 * 
	 * Within the while loop, if the current integer within the array ArrayList is divisible by the variable prime,
	 * the boolean divisible is set to true, and the while loop is broken, otherwise the counter is incremented and
	 * the prime variable is set to the integer in the primes array at the index of counter
	 * 
	 * Once the while loop is exited, the state of the boolean variable divisible is checked. If it is still false,
	 * the integer value at the current array index is added into the primes ArrayList
	 * 
	 * (Basically it iterates through each number between 1 and the set value (100) and tests if its prime by 
	 * determining if it is divisible by any of the prime numbers less than the square root of that number 
	 * rounded up to the next number)
	 * 
	 * Finally, returns the primes ArrayList
	 */
	public ArrayList<Integer> getPrimes() {
		ArrayList<Integer> primes=new ArrayList<Integer>();
		primes.add(2);
		
		for(int i=2;i<array.size();i+=2) {
			int testVar=(int)(Math.sqrt((double) array.get(i).intValue()))+1;
			
			int counter=0;
			int prime=primes.get(counter);
			boolean divisible=false;
			
			while(prime<testVar) {
				if(array.get(i)%prime==0) {
					divisible=true;
					break;
				}
				counter++;
				prime=primes.get(counter);
			}
			
			if(divisible==false)
				primes.add(array.get(i));
		}
		
		return primes;
	}
	
	

	
}
