package com.revature.OOps;

public class Eagle extends Bird {

	@Override
	void fly() {
		System.out.println("eagle flies very high");
		super.fly();
	}

	@Override
	public void makeNoise() {
		System.out.println("eagle makes very loud noise");
		super.makeNoise();
	}
  
}
