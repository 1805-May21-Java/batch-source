package com.revature.hw2;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Pluto is a planet";
		
		char[] myArray = str.toCharArray() ;
		
		for(int idx = 0; idx < myArray.length; idx++) {
			System.out.print(myArray[idx]);
		}
	}
}