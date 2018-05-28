package com.revature.Q12;

public class Question12 {
	public static void main (String[] args) {
		int arr[]= new int[101];
		for(int i=0; i<101; i++) {
			arr[i]=i;
		}
		System.out.println(arr[100]);
		
		for(int i=0; i<101; i++) {
			if(arr[i]%2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}

}
