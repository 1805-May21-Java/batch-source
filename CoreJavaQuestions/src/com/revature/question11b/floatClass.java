package com.revature.question11b;

public class floatClass {
	private float f1;
	private float f2;
	
	public floatClass() {
		super();
		this.f1 = (Float) null;
		this.f2 = (Float) null;
	}
	
	public floatClass(float f1, float f2) {
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
}
