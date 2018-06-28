package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	private int result;
	
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int add(int int1, int int2) {
		result = int1 + int2;
		return result;
	}
	
	public int subtract(int int1, int int2) {
		result = int1 - int2;
		return result;
	}
	
	public int multiply(int int1, int int2) {
		result = int1 * int2;
		return result;
	}
	
	public int divide(int int1, int int2) {
		result = int1 / int2;
		return result;
	}
	
//	public int divide() throws Exception {
//		
//	}

}
