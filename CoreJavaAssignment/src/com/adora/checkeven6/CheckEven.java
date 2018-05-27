package com.adora.checkeven6;

public class CheckEven {

//	public static void main(String[] args) {
//		int n = 216;
//		System.out.println((checkEven(n)? "true" : "false"));	
//	}
	
	public static boolean checkEven(int n) {
		int resultInt = n /2;
		double resultD = n / 2.0;
		return resultInt == resultD ? true : false;
	}

}
