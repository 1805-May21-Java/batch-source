package com.revature.Q12;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		//Scanners that will take in the String and Number index
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		//Prompt for the String and index and the scanner accepting them
		System.out.println("Please enter in the string you want to work with: ");
		String Entry = sc.nextLine();
		int indexed = 0;
		System.out.println("Please enter in the index you want to split along: ");
		indexed = sc2.nextInt();
		
		//Call to SubString Method passed the String and the index
		System.out.println(SubString(Entry, indexed));
	}
	
	static String SubString(String sentence, int index) {
		//If the index passed is larger than the sentence it prints the whole sentence and an error message
		if(index > sentence.length()) {
			System.out.println("Your index is higher than the length of the sentence printing entire sentence: ");
			return sentence;
		}
		//String that will be used to hold the string given from the SubString method
		String split ="";
		//For loop will split the string until it hits its upper bound then returns it 
		for(int i=0;i<index;i++) {
			split+=sentence.charAt(i);
		}
		return split;
	}

}
