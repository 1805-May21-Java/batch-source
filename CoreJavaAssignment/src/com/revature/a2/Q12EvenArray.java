package com.revature.a2;

import java.util.ArrayList;

public class Q12EvenArray {
	
	//using arraylist so they can end at the right time
	private int[] array = new int[100];
	
	public void evenArray() {
		
		for(int i = 0; i < array.length; i++) {
			//+1 cause its 1 to 100
			array[i] = i+1;
		}
		
		//enhanced for loop to print out the needed
		for (int j : array) {
			if (j % 2 == 0) {
				System.out.println(j);
			}
		}
	}
	//getter and setter
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}

}
	
	
