package com.revature.beans;

public class InterfaceDriver {
    public static void main(String args[]) {
        Intertest imp = new Intertest();

        imp.doSomething();
        imp.doSomethingElse();
        System.out.println();
        imp.myAbstractMethod();
        imp.myAbstractMethod();
    }
}
