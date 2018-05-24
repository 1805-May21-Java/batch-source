package com.revature.other;

public class Weird {

	// private floats that just aren't meant to be private this time
	private float var1;
	private float var2;
	
	public Weird() {
		super();
	}

	public Weird(float var1, float var2) {
		super();
		this.var1 = var1;
		this.var2 = var2;
	}

	public float getVar1() {
		return var1;
	}

	public void setVar1(float var1) {
		this.var1 = var1;
	}

	public float getVar2() {
		return var2;
	}

	public void setVar2(float var2) {
		this.var2 = var2;
	}
	
}
