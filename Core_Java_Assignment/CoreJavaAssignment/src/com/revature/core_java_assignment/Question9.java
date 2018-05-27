package com.revature.core_java_assignment;

import java.util.ArrayList;

public class Question9 {
	
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

		for(int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		
		for(Integer num : nums) {
			if(isPrime(num))
				System.out.println(num);
		}
	}

}
