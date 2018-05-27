package com.revature.question2;

public class Question2Driver {

	public Question2Driver() {
		// TODO Auto-generated constructor stub
		super();
	}

    public static void main (String args[]) {
	    Fibonnaci f = new Fibonnaci();
	    for(int i=0;i<25;i++) {
		    System.out.println("f("+i+"): "+f.fib(i));

	    }
    }
}
