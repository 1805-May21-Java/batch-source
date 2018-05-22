package com.revature.beans;

public class bicycle extends vehicle {
    private int wheels = 2;

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
