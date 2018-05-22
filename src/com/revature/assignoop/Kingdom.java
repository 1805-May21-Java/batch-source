package com.revature.assignoop;

public class Kingdom extends Domain{
    private String kName;
    private boolean isPlant;

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public boolean isPlant() {
        return isPlant;
    }

    public void setPlant(boolean plant) {
        isPlant = plant;
    }
}
