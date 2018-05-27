package com.revature.htulipan.solutions.four;

public class FactorialGenerator {
	private int n;
	
	public FactorialGenerator() {
		this.n = 1;
	}
	
	public int findFactorial() {
		int cur = 1;
		int result = 1;
		while (cur <= n) {
			result = result * cur++;
		}
		
		return result;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
}
