package com.revature.assignoop;

public class Genus extends Fam{
    private int legs;
    private String gName;

    public Genus() {
        super();
    }

    public Genus(int legs, String gName) {
        this.legs = legs;
        this.gName = gName;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }
}
