package com.revature.assigncorej;

public class Question4 {
    public static void main(String args[]){
        //How many factorials is n.
        int n = 25;

        //Initialized long.
        long x=1l;

        // Recreated basic factorial formula. Continues to
        // multiply x by each value of x until x reaches 1.
        // Can never reach 0, as multiplying by 0 would
        // result in a 0 result.
        while(n>0){
            x*=(n);
            n--;
        }
        System.out.println(Math.abs(x));
    }
}
