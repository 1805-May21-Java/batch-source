package com.revature.corejava;
//Q2
public class Fibonacci {
	public static void main(String[] args) {
			for(int i=0; i<25; i++) {
				System.out.println(fibonacci(i));
			}
		}

	public static int fibonacci(int n1) {
		if(n1 <= 1) {return n1;}
		return fibonacci(n1-1) + fibonacci(n1-2);
	}
}
