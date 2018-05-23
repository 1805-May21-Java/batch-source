package com.revature.boxing;

public class Driver {
	public static void main(String[] args) {
		
		//Boxing
		int num1 = 5;
		Integer num2 = new Integer(num1);
		System.out.println(num2);
		
		//Un-boxing
		Integer num3 =new Integer(3);
		int num4 = num3.intValue();
		System.out.println(num4);
		
		//AutoBoxing
		int num5 = 12;
		Integer num6 = num5;
		System.out.println(num6);
		
		//Auto Un-boxing
		Integer num7 = 13;
		int num8 = num7;
		System.out.println(num8);
	}
}
