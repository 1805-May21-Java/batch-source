package com.revature.collections;

import java.util.ArrayList;

public class Generics {
    public static void main(String args[]){

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("test");

        Integer[] arr= {1,2,3,4,5,6,7};
        Character[] cArr = {'a','b','a','c','d'};
    }
    public static void printMe(Integer[] arr){
        for (int i:
             arr) {
            System.out.println(arr[i]);
        }
    }
    public static <T> void printMe(T[] arr){
        for (T i: arr) {

        }
    }
}
