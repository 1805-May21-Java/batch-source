package com.revature.abstraction;

public class InterfaceImpl extends MyAbstractClass implements InterfaceA, InterfaceB {

	@Override
	public void doSomething() {
		System.out.println("Doing some stuff");
	}

//	public void doSomethingElse() {
//		
//		System.out.println("Doing something else");
//		//InterfaceB.super.doSomethingElse();
//	}
//	
	@Override
	public void myAbstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("Not so abstract anymore!");
	}


	
}
