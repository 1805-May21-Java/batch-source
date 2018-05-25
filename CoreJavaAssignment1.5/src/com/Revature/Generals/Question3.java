package com.Revature.Generals;

public class Question3 {
	public static void main(String args[]) {
		String str = "Thomas";
		int n = str.length(); //Save initial string length
		
		for ( int i = n - 1; i >= 0; i-- ) { //append the string with itself starting from the end
			str+=str.charAt(i);
		}
		
		str = str.substring(n, str.length()); //Chop off the beginning n characters
		
		System.out.println(str); //Output
	}
}
