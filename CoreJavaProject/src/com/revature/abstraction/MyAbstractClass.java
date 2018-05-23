package com.revature.abstraction;

public abstract class MyAbstractClass {
	public abstract void myAbstractMethod();
	
	public void myConcreteMethod() {
		System.out.println("I came from myConcreteMedthod in MyAbstractClass");
	}

}
