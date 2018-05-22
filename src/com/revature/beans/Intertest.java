package com.revature.beans;

public class Intertest extends MyAbstractClass implements InterfaceA, InterfaceB {

    @Override
    public void doSomething() {

    }

    @Override
    public void doSomethingElse() {
    }

    @Override
    public void myAbstractMethod(){
        System.out.println("Not abstract anymore.");
    }
}
