package com.revature.algorithms;

public class BasicMath implements Arithmetic {

	double num1;
	double num2;
	
	public BasicMath() {
		super();
	}

	public BasicMath(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	// abstract methods from the Arithmetic interface
	
	@Override
	public double add() {
		return (num1 + num2);
	}

	@Override
	public double sub() {
		return (num1 - num2);
	}

	@Override
	public double mult() {
		return (num1 * num2);
	}

	@Override
	// since our hard coded values will be nonzero, let's not error check
	public double div() {
		return(num1 / num2);
	}
}