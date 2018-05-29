package com.revature.banking;

public class Login {
    String u;
    String p;

    public Login(){
        super();
    }
    public static boolean auth(String u, String p){
        AccountList instance = AccountList.getInstance();
        return (instance.getaList().containsKey(u)) && ((instance.getaList().get(u)).getuPass().equals(p));
    }
}
