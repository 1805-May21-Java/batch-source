package com.revature.a2;

import com.revature.q11.*;

public class Q11FloatAccess {
	//using the access from import to find value from another package
	Q11Float q11 = new Q11Float();
	private float a3 = q11.getA1() + q11.getA2();
	
	//getter and setter
	public Q11Float getQ11() {
		return q11;
	}
	public void setQ11(Q11Float q11) {
		this.q11 = q11;
	}
	public float getA3() {
		return a3;
	}
	public void setA3(float a3) {
		this.a3 = a3;
	}
	
	
}
