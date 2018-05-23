package com.revature.abstraction;

//Interfaces are implicitly abstract
//We could include abstract but it wouldn't change anything so why would we?
public interface Interfaces {
	
	//This variable is implicitly public, static, and final -- essentially a public
	//Again we could include those non-access modifiers
	final int MY_INT = 5;
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("Interfaces Doing Some Stuff");
	}
}
