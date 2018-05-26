package com.revature.assigncorej;

import java.util.ArrayList;
import java.util.Iterator;

public class Question8 {
    public static void main(String[] args){
        //"civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> pal = new ArrayList<>();

        arr.add("karan");
        arr.add("madam");
        arr.add("tom");
        arr.add("civic");
        arr.add("radar");
        arr.add("jimmy");
        arr.add("kayak");
        arr.add("john");
        arr.add("refer");
        arr.add("billy");
        arr.add("did");

        int size = arr.size();
        for (String s:
             arr) {
            size = s.length()-1;
            if(palCheck(s, size)) {
                pal.add(s);
            }
        }

        System.out.println(pal.toString());

    }
    private static boolean palCheck(String s, int z){
        z = s.length();
        for (int i=0; i<(z/2); ++i){
            if (s.charAt(i) != s.charAt(z-i-1)){
                return false;
            }
        }

        return true;
    }
}
