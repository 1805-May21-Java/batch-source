package com.revature.beans;

public interface InterfaceB {

    void doSomething();

    default void doSomethingElse(){
        System.out.println("Am doing something else. IB");
    }
}
