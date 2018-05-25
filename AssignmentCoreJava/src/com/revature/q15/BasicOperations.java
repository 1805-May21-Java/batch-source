package com.revature.q15;

public interface BasicOperations {
	
	int addition (int a, int b);
	int subtraction(int a, int b);
	int multiplication(int a, int b);
	//division needs to throw an exception in case you try to divide by 0
	int division(int a, int b) throws Exception;}
