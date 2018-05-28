package com.revature.assignment;

public class Q5 {

	//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
	//Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	
	//Takes string parameter and splits it into an array and prints out array characters specified by int parameter
	public void subString(String str, int idx) {
	String[] array = str.split("");
	for(int i = 0; i <= idx -1; i++) {
		System.out.print(array[i]);
	};
	}
	
//	Driver code
//	Q5 q = new Q5();
//	q.subString("Trampled By Turtles", 7);
}
