package com.revature.corejava.question8;

import java.util.ArrayList;

public class PalindroneDriver {

	public static void main(String[] args) {
		
		// ArrayList created to hold the test names
		ArrayList<String> names=new ArrayList<String>();
		
		// Test names are added in
		names.add("karan");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		// New instance of PalindroneNames is created
		PalindroneNames pn=new PalindroneNames(names);
		
		// Prints out the returned regular names, which should be karan, tom, jimmy, john, and billy
		System.out.println("Regular names:");
		pn.getRegularNames().forEach((name)->System.out.println(name));
		
		// Provide space between the two results
		System.out.println();
		
		// Prints out the returned palindrone names, which should be madam, civic, radar, kayak, refer, did
		System.out.println("Palindrone names:");
		pn.getPalindrones().forEach((palindrone)->System.out.println(palindrone));

	}

}
