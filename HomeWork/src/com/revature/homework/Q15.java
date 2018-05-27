package com.revature.homework;

public class Q15 implements Q152ND {

	public static void main(String[] args) {
		Q15 mathoperation = new Q15();
		System.out.println(mathoperation.add(3, 5));
		System.out.println(mathoperation.sub(4, 5));
		System.out.println(mathoperation.division(5.0, 8.0));
		System.out.println(mathoperation.multiply(9, 2));
		
		
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double division(double a,double b) {
		// TODO Auto-generated method stub
		return (a/b);
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

}
