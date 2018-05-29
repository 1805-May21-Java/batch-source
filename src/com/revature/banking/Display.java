package com.revature.banking;

import com.sun.glass.ui.Screen;

import java.util.Scanner;

public class Display {
    private static int height = 20;
    private static int length = 500;
    private Scanner scanner = new Scanner(System.in);

    public Display() {
        super();
    }

    public static void blankScreen() {
        int x = height;
        int y = 0;

        do {
            System.out.println();
            y++;
        } while (x >= y);
    }

    public static void mainScreen(){
        String title = "Wasnik Central Bank Main Menu";
        String div = ("#####################################################\n");
        int x = 0;

        blankScreen();
        System.out.println(div);
        while (x < (.5*div.length())-(.55*title.length())) {
            System.out.print(" ");
            x++;
        }
        System.out.println(title+"\n");
        System.out.println(div);
        System.out.println("Press a key and then enter/return to continue. \n");
        System.out.println("[R]egister\t [L]ogin\t [E]xit\n");
        System.out.println(div);


    }

    public static void registrationScreen(){
        String title = "Account Registration";
        String div = ("#####################################################\n");
        int x = 0;

        blankScreen();
        System.out.println(div);
        while (x < (.5*div.length())-(.55*title.length())) {
            System.out.print(" ");
            x++;
        }
        System.out.println(title+"\n");
        System.out.println(div);
        System.out.println("Please follow the instructions to continue... \n");
        System.out.println("Enter a username and a password.");
        System.out.println(div);


    }

    public static void loginScreen() {
        String title = "User Login";
        String div = ("#####################################################\n");
        int x = 0;

        blankScreen();
        System.out.println(div);
        while (x < (.5*div.length())-(.55*title.length())) {
            System.out.print(" ");
            x++;
        }
        System.out.println(title+"\n");
        System.out.println(div);
        System.out.println("Please follow the instructions to continue... \n");
        System.out.println("Enter your username and a password.");
        System.out.println(div);
    }

    public static void bankScreen(String u, double z) {
        String title = u+"\'s Bank Account";
        String bal = u+"\'s Bank Balance: "+z;
        double balance = z;

        String div = ("#####################################################\n");
        int x = 0;

        blankScreen();
        System.out.println(div);
        while (x < (.5*div.length())-(.55*title.length())) {
            System.out.print(" ");
            x++;
        }
        x=0;
        System.out.println(title+"\n");
        System.out.println(div);
        while (x < (.5*div.length())-(.55*bal.length())) {
            System.out.print(" ");
            x++;
        }
        System.out.println(bal+"\n");
        System.out.println(div);
        System.out.println("Please select an option and press enter/return.");
        System.out.println("[D]eposit [W]ithdraw [L]ogout [E]xit");
    }
}
