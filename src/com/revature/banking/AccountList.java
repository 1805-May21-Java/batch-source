package com.revature.banking;

import org.jetbrains.annotations.Contract;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * Using a Singleton to store all of the account login and
 * password information using a HashMap. Users should be
 * unique, so using a HashMap would guarantee no duplicate
 * entries.
 *
 */

public class AccountList {
    private static AccountList ourInstance = new AccountList();

    public AccountList(HashMap<String, Account> aList) {
        this.aList = aList;
    }

    @Contract(pure = true)
    public static AccountList getInstance() {
        return ourInstance;
    }
    private HashMap<String,Account> aList = new HashMap();

    AccountList() {
        super();
    }


    @Contract(pure = true)
    public static AccountList getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(AccountList ourInstance) {
        AccountList.ourInstance = ourInstance;
    }

    public HashMap<String, Account> getaList() {
        return aList;
    }

    public void setaList(HashMap<String, Account> aList) {
        this.aList = aList;
    }

    /**
     * Adds an account to the HashMap.
     *
     * @param a Stored as a key, is meant to be the username.
     * @param b Stored as a val, is meant to be the password.
     */
    public void addAccount(String a, Account b) {
        this.aList.putIfAbsent(a,b);
    }

    public String getAccount(String a){
        return this.aList.get(a).getuName();
    }

    public void writeAccounts(){
        String filename = "data.ser";

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(getaList());
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAccounts(){
        try
        {
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.aList = (HashMap<String, Account>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountList that = (AccountList) o;
        return Objects.equals(aList, that.aList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountList{");
        sb.append("aList=").append(aList);
        sb.append('}');
        return sb.toString();
    }
}
