package com.revature.abstraction;

public class InterfaceDriver {

	public static void main(String[] args) {
		
		InterfaceImpl imp1 = new InterfaceImpl();
		imp1.doSomething();
		imp1.doSomethingElse();
		imp1.myAbstractMethod();
	
//		System.out.println();
//		imp1.myConcreteMethod();
//		imp1.myAbstractMethod();
		
//		MyAbstractClass ac = new MyAbstractClass();
	}
	
}
