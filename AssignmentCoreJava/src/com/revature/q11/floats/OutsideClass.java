package com.revature.q11.floats;


public class OutsideClass {
	private float f1;
	private float f2;
	public OutsideClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutsideClass(float f1, float f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}
	public float getF1() {
		return f1;
	}
	public void setF1(float f1) {
		this.f1 = f1;
	}
	public float getF2() {
		return f2;
	}
	public void setF2(float f2) {
		this.f2 = f2;
	}
	@Override
	public String toString() {
		return "OutsideClass [f1=" + f1 + ", f2=" + f2 + "]";
	}
}
