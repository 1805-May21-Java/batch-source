package com.revature.core_java_assignment.Question18;

public class Driver {

	public static void main(String[] args) {
		Question18Concrete q = new Question18Concrete();
		System.out.println(q.hasUppercase("hello"));
		System.out.println(q.hasUppercase("Hello"));
		
		System.out.println(q.toUppercase("hello"));
		
		q.convertToIntAndAdd10("9");

	}

}
