package com.revature.abstraction;

public class InterfaceImpl extends MyAbstractClass implements Interfaces, InterfaceB{

	@Override
	public void doSomething() {
		System.out.println("doSomething in interfaceimpl Doing Something bro");
	}	
	@Override
	public void doSomethingElse() {
		System.out.println("Interfaceimpl doSomethingElse Here!");
	}
	@Override
	public void myAbstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("Interfaceimpl myAbstractMethod Gang Gang");
	}
	
}
