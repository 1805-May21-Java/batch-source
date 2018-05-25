package com.revature.corejava;

import java.util.ArrayList;

//Q12
public class ArrayForLoop {

	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<>();
		for(int i=0; i<=100; i++) {
			intArray.add(i);
		}
		for(int i: intArray) {
			if(i%2==0) {//Checks if a number is even
				System.out.print(i + " ");
			}
		}

	}

}
