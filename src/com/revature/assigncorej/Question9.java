package com.revature.assigncorej;

import java.util.ArrayList;

public class Question9 {
    public static void main(String args[]){
        int c;
        int n = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        do{
            arr.add(n);
            n++;
        }while(n<=100);
        for (int x:arr) {
            if(isPrime(arr.get(x-1))) System.out.print(arr.get(x)+", ");
        }

    }
    private static boolean isPrime(int n){
        if(n<2) return false;
        else if(n==2) return true;
        else if(n%2==0) return false;
        for(int i=3; i*i<=n; i+=2) if(n%i == 0) return false;
        return true;
    }
}
