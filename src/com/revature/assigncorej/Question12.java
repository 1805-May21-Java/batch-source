package com.revature.assigncorej;

public class Question12 {
    public static void main(String args[]){
        int i;
        int d=0;
        int[] arr = new int[100];

        i=arr.length-1;
        for (int x:arr) {
            arr[d]=d+1;
            d++;
        }
        d=0;
        System.out.println("\n--All even numbers in the array --\n");
        for (int x:arr) {
            if(arr[d]%2==0)System.out.print(arr[d]+", ");
            d++;
        }
        System.out.println("\n\n-- Finished Printing --\n");
    }
}
