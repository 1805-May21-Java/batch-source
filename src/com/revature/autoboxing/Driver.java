package com.revature.autoboxing;

public class Driver {
    public static void main(String args[]){

        //Boxing
        int num = 5;
        Integer number = new Integer(num);

        //unboxing
        Integer unit = new Integer(3);
        int val = unit.intValue();

        //Autoboxing
        int val2 = 12;
        Integer val3 = val2;

        //Autounboxing

    }
}
