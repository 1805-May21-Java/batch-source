package com.revature.corejava;

import com.revature.othercorejava.*; // to access other package

public class Q11PackageAccess {

	public static void main(String[] args) {
		
		// access float variables from package othercorejava
		System.out.println("Accessing lucky number: " + Luck.lucky);
		System.out.println("Accessing unlucky number: " + Luck.unlucky);

	}

}
