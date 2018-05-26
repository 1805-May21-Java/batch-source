package com.revature.banking;

import java.util.Objects;

public class Account {
    /**
     *
     * The Account object holds 4 variables.
     * uName holds the user's login name.
     * uPass holds the user's login password.
     * uBal holds the user's current balance.
     * tHold holds the current transaction amount.
     *
     */
    private String uName;
    private String uPass;
    private double uBal;
    private double tHold;

    //Argless constructor.
    public Account(){
        super();
    }

    //Constructor with required inputs.
    public Account(String uName, String uPass) {
        this.uName = uName;
        this.uPass = uPass;
    }

    //Full constructor.
    public Account(String uName, String uPass, double uBal, double tHold) {
        this.uName = uName;
        this.uPass = uPass;
        this.uBal = uBal;
        this.tHold = tHold;
    }


    //Encap functions
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public double getuBal() {
        return uBal;
    }

    public void setuBal(double uBal) {
        this.uBal = uBal;
    }

    public double gettHold() {
        return tHold;
    }

    public void settHold(double tHold) {
        this.tHold = tHold;
    }

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.uBal, uBal) == 0 &&
                Double.compare(account.tHold, tHold) == 0 &&
                Objects.equals(uName, account.uName) &&
                Objects.equals(uPass, account.uPass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uName, uPass, uBal, tHold);
    }

    //Used to make an object's elements visible if needed.
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("uName='").append(uName).append('\'');
        sb.append(", uPass='").append(uPass).append('\'');
        sb.append(", uBal=").append(uBal);
        sb.append(", tHold=").append(tHold);
        sb.append('}');
        return sb.toString();
    }
}
