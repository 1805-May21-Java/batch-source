package com.revature.corejava.question5;

public class SubStringDriver {

	public static void main(String[] args) {
		
		// String variable to get text string
		String string="Hello World";
		
		// Print result of method subString
		// Should print "Hell"
		System.out.println(subString(string, 3));

	}

	/*
	 * Initialize String variable sub
	 * 
	 *  Loop as many times as the value of idx
	 *  
	 *  Get the character at the count and add it to the end of sub
	 *  
	 *  return sub
	 */
	public static String subString(String str, int idx) {
		String sub="";
		int count=0;
		while(count<=idx) {
			sub+=str.charAt(count)+"";
			count++;
		}
		return sub;
	}
	
}
