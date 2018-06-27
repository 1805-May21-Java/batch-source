package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	private double a;
	private double b;
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Calculator [a=" + a + ", b=" + b + "]";
	}
	public double calculate(String operator, double a, double b) throws Exception{
		this.a = a;
		this.b = b;
		if(operator.equals("add")) {
			return this.add();
		} else if (operator.equals("subtract")) {
			return this.subtract();
		} else if (operator.equals("multiply")) {
			return this.multiply();
		} else if (operator.equals("divide")) {
			if(this.b == 0.0) {
				throw new Exception();
			}
			return this.divide();
		}
		return 0;
	}
	
	public double add() {
		return this.a + this.b;		
	}
	
	public double subtract () {
		return this.a - this.b;
	}
	
	public double multiply () {
		return this.a * this.b;
	}
	public double divide () {
		return this.a / this.b;
	}
}
