package com.revature.q11;

public class Q11Float {
	private float a1 = (float) 3.57;
	private float a2 = (float) 1.23;
	
	//getter and setter
	public float getA1() {
		return a1;
	}
	public void setA1(float a1) {
		this.a1 = a1;
	}
	public float getA2() {
		return a2;
	}
	public void setA2(float a2) {
		this.a2 = a2;
	}
	
	public Q11Float(float a1, float a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}
	public Q11Float() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//tostring
	@Override
	public String toString() {
		return "Q11Float [a1=" + a1 + ", a2=" + a2 + "]";
	}
	
	
}
