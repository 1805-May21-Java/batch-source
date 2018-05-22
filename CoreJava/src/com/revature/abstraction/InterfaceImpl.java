package com.revature.abstraction;

public class InterfaceImpl extends MyAbstractClass implements InterfaceA, InterfaceB {

	@Override
	public void doSomething() {
		System.out.println("Doing some stuff");
	}

	@Override
	public void doSomethingElse() {
		InterfaceA.super.doSomethingElse();
	}

	//@Override
//	public void myAbstractMethod() {
//		System.out.println("Not so abstract anymore, eh?");
//	}


}
