package com.revature.beans;

public class Bicycle extends Vehicle {
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
