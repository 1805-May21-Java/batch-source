package com.revature.Q12;

public class Q3 {
	public static void main(String[] args) {
		//String that will be reversed
		String unreversed = "Reverse Reverse!";
		//Method toCharArray which returns a character array
		char[] rev= unreversed.toCharArray();
		//For loop that starts at the back of the array and prints from there
		for(int i =rev.length-1;i>=0;i--)
		{
			//Prints until it reaches the front of the array
			System.out.print(rev[i]);
		}
	}
}
