package com.revature.banking;

import java.util.HashMap;
import java.util.Scanner;

public class ProgramDriver {
    static boolean session;

    public ProgramDriver(){
        super();
    }

    public static void Bank() throws InterruptedException {
        session = false;
        boolean next=false;
        Account a = new Account();

        String s,t = null;
        Scanner scanner = new Scanner(System.in);
        double d,w;
        char c;

        while(!session){
            Display.mainScreen();
            s = scanner.nextLine();

            if(s.equalsIgnoreCase("R")){
                Display.registrationScreen();
                do{
                    System.out.println("Username: ");
                    s = scanner.nextLine();
                    if(s.equalsIgnoreCase("e"))System.exit(1);
                    if(AccountList.getInstance().getaList().containsKey(s))System.out.println("This username is taken.\n" +
                            "Please select another username. Or enter E to exit.\n");
                }while(AccountList.getInstance().getaList().containsKey(s));
                if(!AccountList.getInstance().getaList().containsKey(s))do{
                    System.out.println("Please enter a password: ");
                    t = scanner.nextLine();
                    a.setuPass(t);
                }while(t==null);
                if (!(s==null)&&(!(t==null))){
                    AccountList.getInstance().addAccount(s,a);
                    System.out.println("Account Created!");
                    System.out.print("Redirecting you to Main Menu");
                    s = null;
                    t = null;
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    Bank();
                }


            }
            else if(s.equalsIgnoreCase("L")){
                Display.loginScreen();
                System.out.println("Username: ");
                s = scanner.nextLine();
                if(!AccountList.getInstance().getaList().containsKey(s)){
                    System.out.println("That username does not exist.");
                }
                System.out.println("Password: ");
                t = scanner.nextLine();

                session=Login.auth(s,t);
                a.setuName(s);
                break;
            }
            else if(s.equalsIgnoreCase("E")){
                Display.blankScreen();
                System.exit(1);
            }
            else{
                System.out.println("Unexpected Input, refreshing application.");
                Bank();
            }
        }
        while(session){
            a.setuBal(AccountList.getInstance().getaList().get(a.getuName()).getuBal());
            Display.bankScreen(a.getuName(),a.getuBal());

            if((scanner.hasNextLine())&&next){
                scanner.nextLine();
            }
            String g=scanner.nextLine();
            c=g.toLowerCase().charAt(0);
            next=true;


            switch(c){
                case 'd':
                    System.out.println("How much money would you like to deposit?: ");
                    d = scanner.nextDouble();
                    //a.setuBal(a.getuBal()+d);

                    AccountList.getInstance().getaList().get(a.getuName()).setuBal(a.getuBal()+d);
                    AccountList.getInstance().writeAccounts();

                    continue;
                case 'w':
                    System.out.println("How much money would you like to withdraw?: ");
                    w = scanner.nextDouble();
                    //a.setuBal(a.getuBal()-w);

                    AccountList.getInstance().getaList().get(a.getuName()).setuBal(a.getuBal()-w);
                    AccountList.getInstance().writeAccounts();
                    continue;
                case 'l':
                    session=false;
                    Bank();
                case 'e':
                    AccountList.getInstance().writeAccounts();
                    Thread.sleep(500);
                    System.exit(0);
                default:
                    Bank();
            }
        }
    }
}
