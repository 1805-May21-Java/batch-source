package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public double add(double var1, double var2) {
		return var1+var2;
	}
	
	public double subtract(double var1, double var2) {
		return var1-var2;
	}
	
	public double multiply(double var1, double var2) {
		return var1*var2;
	}
	
	public double divide(double var1, double var2) {
		return var1/var2;
	}

	
}
