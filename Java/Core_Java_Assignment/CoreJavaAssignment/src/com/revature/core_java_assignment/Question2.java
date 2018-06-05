package com.revature.core_java_assignment;

public class Question2 {

	public static int[] fib(int num) { // assumes fib(0) is 0, not 1
		int[] fibNums = new int[num];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for(int i = 2; i < num ; i++) {
			fibNums[i] = fibNums[i - 2] + fibNums[i - 1];
		}
		
		return fibNums;
	}
	
	public static void main(String[] args) {
		int[] fibSequence = fib(25);
		for(int num : fibSequence)
			System.out.println(num);
	}

}
