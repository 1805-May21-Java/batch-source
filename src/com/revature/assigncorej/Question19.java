package com.revature.assigncorej;

import java.util.ArrayList;

public class Question19 {
    public static void main(String args[]){
        int i=0;
        int t=0;
        int u=0;
        ArrayList<Integer> arr = new ArrayList<>();
        do{
            arr.add(i);
            i++;
        }while(i<=10);
        System.out.print("Array of even integers.\n[");
        for (int x:arr) {
            if(arr.indexOf(x)%2==0)System.out.print(arr.indexOf(x)+", ");
            t+=arr.indexOf(x);
        }
        System.out.print("]\nThe sum of these numbers is:"+t+"\n");
        System.out.print("Array of odd integers.\n[");
        for (int x:arr) {
            if(arr.indexOf(x)%2==1)System.out.print(arr.indexOf(x)+", ");
            u+=arr.indexOf(x);
        }
        System.out.print("]\nThe sum of these numbers is:"+u+"\n");

        System.out.println("Removing Prime Numbers");
        int x=0;

        for(int j=0; j<arr.size(); j++){
            if(isPrime(arr.indexOf(j))){
                arr.remove(j);
                x++;
            }
            else if ((j==arr.size())&&(x==j)){
                break;
            }
        }
        System.out.println("Array without primes: "+arr.toString());
    }
    private static boolean isPrime(int n) {
        for(int i=2;i<=n/2;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
