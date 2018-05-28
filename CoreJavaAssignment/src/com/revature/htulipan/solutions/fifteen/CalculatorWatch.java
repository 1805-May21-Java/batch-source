package com.revature.htulipan.solutions.fifteen;

import java.util.Date;

public class CalculatorWatch implements Calculator{
	private Date time;
	private double ans;

	public CalculatorWatch() {
		super();
		this.time = new Date();
		this.ans = 0.0d;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public double getAns() {
		return ans;
	}
	
	public double clear() {
		ans = 0.0d;
		return output();
	}

	public double addition(double first, double second) {
		printTime();
		System.out.println(first + " + " + second);
		ans = first + second;
		return output();
	}
	
	public double addition(double only) {
		printTime();
		System.out.println(ans + " + " + only);
		ans += only;
		return output();
	}
	
	public double subtraction(double first, double second) {
		printTime();
		System.out.println(first + " - " + second);
		ans = first - second;
		return output();
	}
	
	public double subtraction(double only) {
		printTime();
		System.out.println(ans + " - " + only);
		ans -= only;
		return output();
	}
	
	public double multiplication(double first, double second) {
		printTime();
		System.out.println(first + " * " + second);
		ans = first * second;
		return output();
	}
	
	public double multiplication(double only) {
		printTime();
		System.out.println(ans + " * " + only);
		ans *= only;
		return output();
	}
	
	public double division(double first, double second) {
		printTime();
		System.out.println(first + " / " + second);
		ans = first / second;
		return output();
	}
	
	public double division(double only) {
		printTime();
		System.out.println(ans + " / " + only);
		ans /= only;
		return output();
	}
	
	private double output() {
		System.out.println(ans);
		return ans;
	}
	
	public void printTime() {
		time = new Date();
		System.out.println(time);
	}
}
