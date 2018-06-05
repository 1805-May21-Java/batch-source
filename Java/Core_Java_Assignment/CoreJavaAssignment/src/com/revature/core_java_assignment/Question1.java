package com.revature.core_java_assignment;

public class Question1 {
	public static void bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = 1; j < nums.length - i; j++) {
				if(nums[j - 1] > nums[j]) { // swap numbers so the biger numbers bubble up to the end of the array
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		bubbleSort(nums);
		for(int i : nums)
			System.out.println(i);
	}
}