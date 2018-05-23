package com.revature.abstraction;

public interface InterfaceB extends InterfaceA {

	void doSomething();
	default void doSomethingElse() {
		System.out.println("Inside InterfaceB");
	}
	
}
