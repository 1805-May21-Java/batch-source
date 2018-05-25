package com.Revature.Generals;

import java.util.ArrayList;

public class Question12 {
	public static void main(String ags[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < 101; i++) { // Initialize array with values
			arr.add(i);
		}
		
		Integer iArr[] = new Integer[arr.size()]; //Put all values in real array
		arr.toArray(iArr);

		for (Integer i : iArr) { //Works with Array or ArrayList
			if (i % 2 == 0) { // Check if i is even
				System.out.println(i);
			}
		}
	}

}
