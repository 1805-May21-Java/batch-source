package com.revature.autoboxing;

public class Driver {

	public static void main(String[] args) {
		
		// Boxing
		int num1 = 5;
		Integer num2 = new Integer(num1); 
		
		// Unboxing
		Integer num3 = new Integer(3);
		int num4 = num3.intValue();
		
		// Autoboxing 
		int num5 = 12;
		Integer num6 = num5;
		
		// Auto Unboxing
		Integer num7 = 13;
		int num8 = num7;
		
	}

}
