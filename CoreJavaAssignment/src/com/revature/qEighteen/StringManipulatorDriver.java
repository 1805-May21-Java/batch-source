package com.revature.qEighteen;

public class StringManipulatorDriver
{
	public static void main(String[] args)
	{
		ManipulatorOfStrings mos = new ManipulatorOfStrings();
		String value = "his has One in the middle";
		
		System.out.println(mos.hasUpperCase(value));
		System.out.println(mos.toUpperCase(value));
		mos.numberManipulation("37");
		mos.numberManipulation("not a number");
	}
}
