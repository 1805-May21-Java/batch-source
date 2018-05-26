package com.revature.threads;

public class Count {
    public int count;
    public synchronized void increment(){
        count++;
    }
}
