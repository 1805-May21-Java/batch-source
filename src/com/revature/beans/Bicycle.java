package com.revature.beans;

public class Bicycle extends Vehicle {
    private int wheels = 2;

    public Bicycle(){
        super();
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bicycle{");
        sb.append("wheels=").append(wheels);
        sb.append('}');
        return sb.toString();
    }
}
