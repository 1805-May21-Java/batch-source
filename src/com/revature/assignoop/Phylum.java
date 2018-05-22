package com.revature.assignoop;

public class Phylum extends Kingdom{
    private boolean hasSpine;
    private boolean hasBones;

    public boolean isHasSpine() {
        return hasSpine;
    }

    public void setHasSpine(boolean hasSpine) {
        this.hasSpine = hasSpine;
    }

    public boolean isHasBones() {
        return hasBones;
    }

    public void setHasBones(boolean hasBones) {
        this.hasBones = hasBones;
    }
}
