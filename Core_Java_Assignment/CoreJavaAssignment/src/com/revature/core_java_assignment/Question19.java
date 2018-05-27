package com.revature.core_java_assignment;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Question19 {
	
	public static boolean isPrime(int num) {
		if(num == 1)
			return false;
					
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i = 1; i <= 10; i++)
			nums.add(i);
		
		System.out.println(nums);
		
		int evenSum =0;
		for(Integer num: nums) {
			if(num % 2 == 0)
				evenSum += num;
		}
		System.out.println("The sum of the even numbers between 1 and 10 is " + evenSum);
		
		int oddSum = 0;
		for(Integer num: nums) {
			if(num % 2 == 1)
				oddSum += num;
		}
		System.out.println("The sum of the odd numbers between 1 and 10 is " + oddSum);
		
		ArrayList<Integer> nonPrimeNums = (ArrayList<Integer>) nums.stream().filter(num -> !isPrime(num)).collect(Collectors.toList());

		System.out.println("The nonprime numbers between 1 and 10 are " + nonPrimeNums);
	}

}
