package com.revature.assigncorej;

public class Question6 {
    public static void main(String args[]){
        int[] arr = new int[]{4,7,8};
        int g = arr.length-1;
        while(g>=0) {
            if (isEven(arr[g])) {
                System.out.println("This element is even.");
            } else {
                System.out.println("This element is not even.");
            }
            g--;
        }
    }
    public static boolean isEven(int x){
        while(x>1){
            x-=2;
        }
        if(x==0)return true;
        else return false;
    }
}
