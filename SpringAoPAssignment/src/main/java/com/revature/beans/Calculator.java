package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public int add(int a1, int a2) {
		return a1+a2;
	}
	public int subtract(int a1, int a2) {
		return a1-a2;
	}
	public int multiply(int a1, int a2) {
		return a1*a2;
	}
	public int divide(int a1, int a2) {
		return a1/a2;
	}
	public int mod(int a1, int a2) {
		return a1%a2;
	}
	public int xor(int a1, int a2) {
		return a1^a2;
	}
	

}
