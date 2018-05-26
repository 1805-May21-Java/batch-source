package com.revature.hw2;

public class q18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q18p2 impl = new q18p2();
	
		String myString = "This is a TEST";
		String myNumString = "70";
		System.out.println("myString has CAPITAL letters: " + impl.upperCheck(myString));
		System.out.println("myString in lowercase: "+ impl.lowerConvert(myString));
		System.out.println("myString as a number: "+ impl.intConverter(myNumString));
	}
}
