package com.revature.assigncorej;

import com.revature.accessfl.FloatDriver;

public class Question11 {
    public static void main(String args[]){
        float x,y;

        myFloat f = new myFloat();
        x = f.getF();
        y = f.getF2();

        System.out.print(x+", "+y);
    }
}

class myFloat extends FloatDriver{

}
