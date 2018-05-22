package com.revature.beans;

public class Submarine extends Vehicle {
    private int torpedoCount;
    private int depth;
    private boolean periscopeExtended;
    private boolean redAlert;

    public Submarine(){
        super();
    }
    public Submarine(int torpedoCount, int depth, boolean periscopeExtended, boolean redAlert){
        this.torpedoCount = torpedoCount;
        this.depth = depth;
        this.periscopeExtended = periscopeExtended;
        this.redAlert = redAlert;
    }

    public int getTorpedoCount() {
        return torpedoCount;
    }

    public void setTorpedoCount(int torpedoCount) {
        this.torpedoCount = torpedoCount;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean isPeriscopeExtended() {
        return periscopeExtended;
    }

    public void setPeriscopeExtended(boolean periscopeExtended) {
        this.periscopeExtended = periscopeExtended;
    }

    public boolean isRedAlert() {
        return redAlert;
    }

    public void setRedAlert(boolean redAlert) {
        this.redAlert = redAlert;
    }
}
