package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator
{
	public Calculator()
	{
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public double add(double v1, double v2) {
		return v1 + v2;
	}
	
	public double subtract(double v1, double v2) {
		return v1 - v2;
	}
	
	public Double multiply(double v1, double v2) { 
		return v1 * v2;
	}
	
	public  double divide(double v1, double v2) {
		return v1/v2;
	}
}
