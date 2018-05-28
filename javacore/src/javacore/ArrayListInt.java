package javacore;

import java.util.ArrayList;

public class ArrayListInt {
	public static boolean isPrime(int n) {
	    // Test even factors first using bitwise and.
	    if(n > 2 && (n & 1) == 0)
	       return false;
	    //now test odd
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) 
	            return false;
	    return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			ints.add(i);
		}
		
		System.out.println("ArrayList: " + ints);
		//sum of even numbers
		int eSum = 0;
		for(int i : ints) {
			if(i % 2 ==0) {
				eSum += i;
			}
		}
		
		System.out.println("Sum of even numbers from list: " + eSum);
		//sum of odd numbers
		int oSum = 0;
		for(int i: ints) {
			if(i % 2 == 1) {
				oSum += i;
			}
		}
		
		System.out.println("Sum of od numbers from list " + oSum);
		int pSum = 0;
		for(int i: ints) {
			if(isPrime(i)) {
				pSum += ints.get(i) - 1;
			}
			
		}
		
		System.out.println("The sum of prime numbers in the array are: " + pSum);
		
	}
}
