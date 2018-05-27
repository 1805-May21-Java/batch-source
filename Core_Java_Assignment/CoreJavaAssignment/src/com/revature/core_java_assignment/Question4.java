package com.revature.core_java_assignment;

public class Question4 {
	
	public static int factorial(int num) {
		if(num == 0)
			return 1;
		return num * factorial(--num);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(9));
	}
}
