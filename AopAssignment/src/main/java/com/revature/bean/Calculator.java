package com.revature.bean;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public double add(double a, double b) {
		return (a + b);
	}
	public double sub(double a, double b) {
		return (a - b);
	}
	public double mul(double a, double b) {
		return (a * b);
	}
	public double div(double a, double b) {
		return (a / b);
	}
}
