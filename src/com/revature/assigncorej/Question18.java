package com.revature.assigncorej;

public class Question18 {
    public static void main(String args[]){
        Person p = new Person();

        System.out.println(p.chechUpper("ellO"));
        System.out.println(p.setLower("HELLO"));
        System.out.println(p.sayInt("Doopdedoop"));
    }
}

class Person extends HumanChecks{
    Person(){
        super();
    }
    Person(String s){

    }

    @Override
    public boolean chechUpper(String f) {
        return super.chechUpper(f);
    }

    @Override
    public String setLower(String s) {
        return super.setLower(s);
    }

    @Override
    public int sayInt(String s) {
        return super.sayInt(s);
    }
}

abstract class HumanChecks{
    public boolean chechUpper(String f){
        int g = f.length()-1;

        do{
            if(Character.isUpperCase(f.indexOf(g)))return true;
            g--;
        }while(g>=0);

        return false;
    }
    public String setLower(String s){
        return s.toLowerCase();
    }
    public int sayInt(String s){
        int x = Integer.parseInt(s);
        return x+10;
    }
}