package com.revature.abstraction;

public interface InterfaceB {
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("Interface B is doing Something diffrent");
	}
}
