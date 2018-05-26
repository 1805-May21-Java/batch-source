package com.revature.assigncorej;

public class Question13 {
    public static void main(String args[]){
        for(int i=0; i<=4; i++){
            System.out.println();
            for(int n=i; n!=0; n--){
                int x=(n%2==0? 1:0);
                System.out.print(x);
            }
        }
    }
}
