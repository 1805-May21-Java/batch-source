package com.revature.beans;

/*
Interfaces are implicitly abstract.
We could include abstract, but it wouldn't change anything.
So why would we?
 */
public interface InterfaceA {
    /*
    This variable is implicitly public, static, and final.
    Essentially public. Again, we could include those non-access modifiers.
     */
    int MY_INT = 6;

    void doSomething();

    default void doSomethingElse(){
        System.out.println("This may be some interfaceA output.");
    }
}
