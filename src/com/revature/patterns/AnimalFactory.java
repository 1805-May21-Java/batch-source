package com.revature.patterns;

class AnimalFactory {
    Animal getAnimal(String a){
        a=a.toLowerCase();
        switch (a) {
            case "cat":
                return new Cat();
            case "hippo":
                return new Hippopotamus();
            case "tarsier":
                return new Tarsier();
            default:
                return null;
        }
    }
}
