package com.revature.q12;

public class EvenArrayDriver {
	public static void main(String[] args) {
		int[] hundred = new int[100];
		for(int i = 0; i < 100; i++) {
			hundred[i] = 1 + i;
		}
		
		System.out.println("Here are the even numbers up to 100: ");
		for(int num : hundred) {
			if(num % 2 == 0) {
				System.out.print(num + " ");
			}
		}
	}
}
