package com.revature.Q12;

import java.util.*;

public class Q8 {
	public static void main(String[] args) {
		//Initialize both  arrays
		ArrayList<String> List =new ArrayList<String>();
		ArrayList<String> Pala =new ArrayList<String>();
		//Fill List with the unsorted strings
		List.add("karan");
		List.add("madam");
		List.add("tom");
		List.add("civic");
		List.add("radar");
		List.add("jimmy");
		List.add("kayak");
		List.add("john");
		List.add("refer");
		List.add("billy");
		List.add("did");
		//For loop to navigate through List and pass each word to the function
		for(int i=0;i<List.size()-1;i++) {
			//Used ((String)List.get()) Function to find and return string in that location of array
			if(PaliFind((String)List.get(i))) {
				//if PaliFind returns true word gets added to Pala ArrayList if not then ignored
				Pala.add((String)List.get(i));
			}
		}
		System.out.println("The Palindromes in the given array are: "+Pala);
	}
	public static boolean PaliFind(String a) {
		String Rev = "";
		for(int i =a.length()-1; i>= 0;i--) {
			//Reverse the String to compare it to un-reversed String
			Rev= Rev+a.charAt(i);
		}
		//Returns a true or false 
		return a.equals(Rev);
	}

}
