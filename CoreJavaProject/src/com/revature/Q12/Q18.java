package com.revature.Q12;

public class Q18 {
	public static void main(String[] args) {
		//All the strings that will be used
		String words = "Hello Friend!";
		String low = "i wanna be big";
		String num = "12345";
		//Created boolean to receive answer from UpperCase check
		boolean answer;
		answer = UpperCase(words);
		if(answer == true) {
			System.out.println("String contained uppercase");
		}else {
			System.out.println("No uppercase found");
		}
		//Pass string so it can be changed to upperase and returned
		String Upper = LowUp(low);
		System.out.println(Upper);
		
		//Pass string so it can be attempted to be parsed and changed to an int
		int num2 = StrtoInt(num);
		System.out.println(num2);
	}
	public static boolean UpperCase(String s) {
		//.equals checks to see if the string is equal to a complete lowercase version if not then it sends back true
		boolean hasUpper = !s.equals(s.toLowerCase());
		return hasUpper;
	}
	
	public static String LowUp(String s) {
		//.toUpperCase takes each char and swaps it with the uppercase letter
		String result = s.toUpperCase();
		return result;
	}
	
	public static int StrtoInt(String s) {
		//Parses the string and attempts to match it and change it to an int
		int number = Integer.parseInt(s);
		return number;
	}

}
