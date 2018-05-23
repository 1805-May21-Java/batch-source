package com.revature.abstraction;

public class InterfaceDriver {
	public static void main(String[] args) {
		InterfaceImpl impl = new InterfaceImpl();
		impl.doSomething();
		impl.doSomethingElse();
		System.out.println();
		impl.myConcreteMethod();
		impl.myAbstractMethod();
	}

}
