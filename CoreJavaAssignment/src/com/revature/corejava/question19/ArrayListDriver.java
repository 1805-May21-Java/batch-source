package com.revature.corejava.question19;

import java.util.function.Consumer;

public class ArrayListDriver {

	public static void main(String[] args) {
		
		// Create new ArrayListClass and add 1-10 to the ArrayList array
		ArrayListClass alc = new ArrayListClass(10);
		
		// Lambda for simplifying ArrayList printing
		Consumer<Integer> print=(i)-> System.out.print(i+" ");
		
		// Print ArrayList before any changes
		// Should print 1-10
		System.out.println("Original ArrayList");
		alc.getArray().forEach(print);
		System.out.println();
		System.out.println();
		
		// Print out the sum of all the evens in the array
		// Should print 30
		System.out.println("Add all evens");
		System.out.println(alc.addEvens());
		System.out.println();
		
		// Print out the sum of all the odds in the array
		// Should print 25
		System.out.println("Add all odds");
		System.out.println(alc.addOdds());
		System.out.println();
		
		// Remove all the primes from the array list and print the updated list
		// Should print 1 4 6 8 9 10
		System.out.println("Remove primes from list and display what is left");
		alc.removePrimes();
		alc.getArray().forEach(print);

	}

}
