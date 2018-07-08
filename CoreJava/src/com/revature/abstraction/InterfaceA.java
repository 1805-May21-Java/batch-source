package com.revature.abstraction;

//interfaces are implicitly abstract
//we could include abstract but it wouldn't change anything so why would we?
public interface InterfaceA {
 
	//this variable is implicitly public, static, and final -- essentially a public constant
	//again we could include those non-access modifiers
	int MY_INT = 5;
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else.. ");
	}
	
}
