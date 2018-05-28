package com.revature.q15;

public class Driver {

	public static void main(String[] args) {
		int first = 100;
		int second = 25;
		
		Question q = new Question();
		System.out.println(q.addition(first, second));
		System.out.println(q.division(first, second));
		System.out.println(q.multiplcation(first, second));
		System.out.println(q.subtraction(first, second));

	}

}
