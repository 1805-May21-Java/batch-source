package com.revature.assigncorej;

import java.util.Scanner;

public class Question17 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double p, r, t;
        System.out.println("Enter how much you want to invest: ");
        p = (double) sc.nextDouble();
        System.out.println("Enter the interest rate: ");
        r = (double) sc.nextDouble();
        System.out.println("Enter years of equity: ");
        t = (double) sc.nextDouble();

        r=r/100;
        System.out.println("Your new balance will be: "+((p*r*t)+p));
        System.out.println("You have earned ["+(p*r*t)+"] in interest.");
    }
}
