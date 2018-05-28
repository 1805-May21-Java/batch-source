package com.revature.corejava.question8;

import java.util.ArrayList;

import com.revature.corejava.question3.ReverseString;

public class PalindroneNames {
	
	// Create two instances of ArrayList with String generic, names to hold the regular names, palindrones to hold
	// palindrones
	private ArrayList<String> names=new ArrayList<String>();
	private ArrayList<String> palindrones=new ArrayList<String>();
	
	// Constructor to create a new instance of PalindroneNames by calling the super class
	public PalindroneNames() {
		super();
	}
	
	// Constructor to create a new instance of PalindroneNames by calling the super class and also calling the 
	// private PalindroneNames method checkForPalindrones that will set names to the regular names and palindrones
	// to the palindrones
	public PalindroneNames(ArrayList<String> names) {
		super();
		checkForPalindrones(names);
	}
	
	// Getter to return the regular names
	public ArrayList<String> getRegularNames() {
		return names;
	}

	// Setter to set the names variable to the regular names and the palindrones variable to the palindrones
	public void setNames(ArrayList<String> names) {
		checkForPalindrones(names);
	}

	// Getter to return the palindrone names
	public ArrayList<String> getPalindrones() {
		return palindrones;
	}

	/*
	 * Method to check the given ArrayList of strings for palindrones
	 * 
	 * First creates a ReverseString object (Class I used to complete question 3) named reverse and int variable half
	 * 
	 * Second, a for loop iterates through all of the strings in ArrayList names. 
	 * 
	 * During each iteration, the half variable is set the be value of half the length of the current string 
	 * (name), and reverse is instantiated with a substring of name (starting at the value of half, or in other
	 * words the substring given is the second half of the name string).
	 * 
	 * The value of the string in reverse is then compared to the first half of the name variable 
	 * (name.substring(0,half))
	 * 
	 * If the strings are equal, than that means that the string name is a palidrone, and is therefore added to 
	 * the palindrones ArrayList
	 * 
	 * Else, the name string is not a palidrone and is therefore added to the names ArrayList
	 * 
	 */
	
	private void checkForPalindrones(ArrayList<String> names){
		ReverseString reverse;
		int half;
		
		for(String name:names) {
			
			half=name.length()/2;
			
			reverse=new ReverseString(name.substring(half+1));
			
			if(name.substring(0, half).equals(reverse.getReversedString())) 
				this.palindrones.add(name);
			else
				this.names.add(name);
		}
	}
	
	

}
