package com.revature.hw2;

import com.revature.hw2.Q15func;

public class Q15 extends Q15func{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q15func impl = new Q15func();

		int num1 = 10, num2 = 5;
		System.out.println(num1 + " + "+ num2 +" is "+ impl.adder(num1,num2));
		System.out.println(num1 + " - "+ num2 +" is "+ impl.subtracter(num1,num2));
		System.out.println(num1 + " * "+ num2 +" is "+ impl.multiplier(num1,num2));
		System.out.println(num1 + " / "+ num2 +" is "+ impl.divider(num1,num2));
	}
}