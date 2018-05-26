package com.revature.hw2;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		for(int x = 1; x <= 10; x++) {
			nums.add(x);
		}
		System.out.println(nums);
		
		int total=0;
		for(int x = 1; x <= 10; x++) {
			if(x % 2 == 0) {
				total+=x;
			}
		}
		System.out.println(total);
		total = 0;
		
		for(int x = 1; x <= 10; x++) {
			if(x % 2 == 1) {
				total+=x;
			}
		}
		System.out.println(total);
		
		boolean isPrime;
		for(int z = 2; z <= 10; z++)
		{
		 isPrime = true;
			for(int a = 2; a < z; a++)
			{
				if(z % a == 0)
				{
					isPrime = false;
					nums2.add(z);
					break;				
				}
				if (a == (z - 1))
				{
					// 'a' is prime, do something here!
					break;				
				}
			}
		}
		System.out.println(nums2);
	}
}