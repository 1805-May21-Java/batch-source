package com.adora.printeven12;

public class PrintEven {
	
	public static void main (String[] args) {
		
		int[] array = new int[100];
		
		for(int i = 0; i < 100; i++) {
			array[i] = i + 1;
		}
		
		for(int a : array) {
			if(a % 2 == 0) {
				System.out.println(a);
			}
		}
		
	}

}
