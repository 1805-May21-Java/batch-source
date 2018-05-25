package com.revature.question15;

public class CalculatorDriver extends Calculator
{
	public static void main(String[] args)
	{
		int val1 = 9;
		int val2 = 3;
		CalculatorDriver cd = new CalculatorDriver();

		System.out.println(cd.add(val1, val2));
		System.out.println(cd.subtract(val1, val2));
		System.out.println(cd.multiply(val1, val2));
		System.out.println(cd.divide(val1, val2));
	}
}
