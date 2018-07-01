package com.revature.beans;

public class BearWithSetter extends Bear{
    private int id;
    private String name;
    private Cave cave;
    
    public void setCave(Cave cave) {
        this.cave = cave;
    }

    @Override
    public String toString() {
        return "BearWithSetter [id=" + id + ", name=" + name + ", cave=" + cave + "]";
    }
    
    @Override
    public void methodInBear() {
        System.out.println("Method in BearWithSetter, this bear is " + toString());
    }
}
