package com.revature.core_java_assignment;

public class Question12 {

	public static void main(String[] args) {
		int[] nums = new int[100];
		for(int i = 0; i < 100; i++) {
			nums[i] = i + 1;
		}
		
		for(int num : nums) {
			if(num % 2 == 0)
				System.out.println(num);
		}
	}

}
