package com.revature.patterns;

public class Singleton {
    private int val;

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        if (ourInstance == null){
            ourInstance = new Singleton();
        }
        return ourInstance;
    }

    private Singleton() {
        super();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{

        throw new CloneNotSupportedException();

    }
}
