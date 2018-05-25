package com.revature.corejava;


//Q16
public class StringLength {


	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Invalid Execution.  Please supply 1 and only 1 string argument.");
			return;
		}
		char[] thing = args[0].toCharArray();
		System.out.println(thing.length);
		
		
	}

}
