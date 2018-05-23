package com.revature.abstraction;

public interface InterfaceA {

	int MY_INT = 5;
	
	void doSomething();
	default void doSomethingElse(){
		System.out.println("Inside InterfaceA");
	}
	
}
