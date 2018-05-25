package com.Revature.Generals;

import java.util.ArrayList;

public class Question2 {
	public static void main(String args[] ) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(1); //Add first to increments of fibonacci sequence
		
		for ( int i = 2; i < 25; i++ ) {
			//Calculate fib using last two values
			arr.add(arr.get(i-1)+arr.get(i-2));
		}
		
		System.out.println(arr); //Output
	}
}
