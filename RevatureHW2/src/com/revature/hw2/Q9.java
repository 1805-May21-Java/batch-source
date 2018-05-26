package com.revature.hw2;
import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> Primes = new ArrayList<Integer>();
		
		for(int x = 1; x <= 100; x++) {
			nums.add(x);
		}
				
		boolean isPrime;
		Primes.add(2);	
		for(int z = 2; z <= 100; z++)
		{			
		 isPrime = true;
			for(int a = 2; a < z; a++)
			{
				if(z % a == 0)
				{
					isPrime = false;
					break;
				}
				if (a == (z - 1))
				{
					// 'a' is prime, do something here!
					Primes.add(z);					
				}
			}
		}
		
		//I should have these numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
		// 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
		System.out.println(Primes);
	}
}