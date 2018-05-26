package com.revature.hw2;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0, num2=1, total;
		for(int x = 0; x < 25; x++) {
			total = num1 + num2;
			System.out.println(num1 + " + " + num2 + " = " +total);
			num1 = num2;
			num2 = total;
		}
	}
}
