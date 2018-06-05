package com.revature.q9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
    
		System.out.println("Enter number to get primes from 1 to number:");
	    int limit = new Scanner(System.in).nextInt();
	    
	    System.out.println("Printing primes from 1 to " + limit);
	    for(int number = 2; number<=limit; number++){
	          //print prime numbers only
	    	if(isPrime(number)){
	    		System.out.println(number);
	          }
	      }

	    }

	    public static boolean isPrime(int number){
	        for(int i = 2; i < number; i++){
	           if(number % i == 0){
	               return false; //number is divisible so its not prime
	           }
	        }
	        return true; //number is prime now
	    }
		 
		
	
}	
	


