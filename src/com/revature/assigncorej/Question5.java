package com.revature.assigncorej;

public class Question5 {
    public static void main(String args[]){
        //Initialized s to copyright friendly value.
        String s = "Mostly Orange-Akin Beverage.";
        //Initialize what will eventually be our index.
        int x = 5;

        //function call with index value.
        sString(s,x-1);
    }

    //Takes a string and index input.
    private static void sString(String s, int idx) {

        if (0<=idx){
            int x = idx;
            int y = 0;
            while(y<=x) {
                System.out.print(s.charAt(y));
                y++;
            }
        }else{
            int x = s.length();
            while(x<idx){
                System.out.print(s.charAt(idx));
                x++;
            }
        }
    }
}
