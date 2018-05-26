package com.revature.assigncorej;

import java.util.Date;

public class Question14 {
    public static void main(String args[]){
        int x = 1;
        int y = 25;
        int z = 0;

        Date d1 = new Date();
        String s = "I am learning Core Java";
        int sl = s.length();

        String[] sa = new String[sl];

        switch(x){
            case 1:
                System.out.println(Math.sqrt((double) y));
                break;
            case 2:
                System.out.println("The current date is: "+d1);
                break;
            case 3:
                    sa[z]=s.substring(0,sl/2);
                    z++;
                    sa[z]=s.substring(sl/2,sl-1);
                break;
            default: System.out.println("Number selection out of bounds.");
                break;
        }
    }
}
