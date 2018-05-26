package com.revature.assigncorej;

public class Question3 {
    public static void main(String args[]){
        //Example String with copyright friendly value.
        String s = "Spanjbib laughs funny.";

        //Initializes an int that is the size of the array.
        int l = s.length()-1;

        //Prints the highest order char to the lowest order char
        //by referencing a constantly reducing integer value,
        //printing every time.
        do{
            System.out.print(s.charAt(l));
            l--;
        }while(l>=0);
    }
}
