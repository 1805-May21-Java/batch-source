package com.revature.assignoop;

public class Fam extends Order{
    private String fName;
    private boolean hasClorophyl;

    public Fam(){
        super();
    }

    public Fam(String fName, boolean hasClorophyl) {
        this.fName = fName;
        this.hasClorophyl = hasClorophyl;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public boolean isHasClorophyl() {
        return hasClorophyl;
    }

    public void setHasClorophyl(boolean hasClorophyl) {
        this.hasClorophyl = hasClorophyl;
    }
}
