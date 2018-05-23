package com.revature.beans;

import com.revature.exceptions.NegativeSpeedException;
import com.sun.org.apache.xpath.internal.operations.Neg;

public class Vehicle {

    private int weightCapacity;
    private int weightCarrying;
    private int passengers;
    private int speed;
    private int wheels = 4;
    private String color;
    private String driver;

    public Vehicle(){

    }

    public Vehicle(int weightCapacity, int weightCarrying, int passengers, int speed, int wheels, String color, String driver){
        this.weightCapacity = weightCapacity;
        this.weightCarrying = weightCarrying;
        this.passengers = passengers;
        this.speed = speed;
        this.wheels = wheels;
        this.color = color;
        this.driver = driver;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
        System.out.println("The Vehicle now has "+this.wheels+" wheels.");
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
        System.out.println("The weight Capacity has been set to "+this.weightCapacity+".");
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
        System.out.println("The Vehicle now has "+this.passengers+" passengers.");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("The speed of the Vehicle has been modified to "+this.speed+"MPH.");
    }

    public void slowDown(int speed){
        this.speed -= speed;
        if(this.speed<0) {
            try {
                throw new NegativeSpeedException();
            }catch(NegativeSpeedException e){
                e.printStackTrace();
            }
        }
        System.out.println("The Vehicle has slowed down.");
    }

    public void speedUp(int speed){
        this.speed += speed;
        System.out.println("The Vehicle has sped up.");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("The color of the Vehicle is now "+this.color+".");
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
        System.out.println("The driver's name has been set to ["+this.driver+"].");
    }

    public int getWeightCarrying() {
        return weightCarrying;
    }

    public void setWeightCarrying(int weightCarrying) {
        this.weightCarrying = weightCarrying;
        System.out.println("The Vehicle is now carrying "+this.weightCarrying+" lbs.");
    }

    public boolean overCapacity(){
        return (weightCarrying>weightCapacity);
    }
    public boolean underCapacity(){
        return (weightCarrying<weightCapacity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("weightCapacity=").append(weightCapacity);
        sb.append(", weightCarrying=").append(weightCarrying);
        sb.append(", passengers=").append(passengers);
        sb.append(", speed=").append(speed);
        sb.append(", wheels=").append(wheels);
        sb.append(", color='").append(color).append('\'');
        sb.append(", driver='").append(driver).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
