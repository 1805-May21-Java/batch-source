package com.revature.assigncorej;

import java.util.Arrays;

public class Question2 {
    public static void main(String args[]){
        //How many Fib iterations, initialized.
        int n = 25;
        int x = 0;

        //Array to store and find values.
        int[] arr = new int[n];

        //Initializations. Fib requires 2 previous values.
        arr[0] = 0;
        arr[1] = 1;

        //Loop arithmetically emulates Fib sequence. Fn = F(n-1)+(Fn-2)
        //Performs this until the number of instances instantiated by the n variable is 0.
        do{
            if(x-1>0) arr[x]+=(arr[x-1])+(arr[x-2]);

            x++;
            n--;
        }while(n!=0);

        //Prints out the sequence.
        System.out.println(Arrays.toString(arr));
    }
}
