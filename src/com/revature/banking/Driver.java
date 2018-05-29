package com.revature.banking;

import java.io.File;

public class Driver {
    public static void main(String args[]){
        File f = new File("data.ser");
        if(f.exists() && !f.isDirectory()) {
            AccountList.getInstance().getAccounts();
        }
        try {
            ProgramDriver.Bank();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
