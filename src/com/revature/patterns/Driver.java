package com.revature.patterns;

public class Driver {
    public static void main(String args[]){

        Singleton instance0 = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println("Instance 1 hash: "+instance0.hashCode());
        System.out.println("Instance 2 hash: "+instance1.hashCode());

        instance0.setVal(5);
        System.out.println(instance1.getVal());

        AnimalFactory af = new AnimalFactory();
        af.getAnimal("cat").Speak();
        af.getAnimal("hippo").Speak();
        af.getAnimal("tarsier").Speak();

    }
}
