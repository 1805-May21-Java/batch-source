package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDriver {
    public static void main(String args[]){
        try{
            //get our class
            Class c1 = Class.forName("com.revature.beans.Bicycle");
            System.out.print("Class"+c1.getName());
            System.out.println();
            
            //get the Class's fields.
            System.out.println("========= CLASS =========");
            System.out.println("Fields: ");
            Field[] fields = c1.getDeclaredFields();
            for (Field y:fields) {
                System.out.println(Modifier.toString(y.getModifiers())+" "+y.getType()+" "+y.getName());
            }

            //Grabbing all the modifiers and the types from the superclasses.
            System.out.println("========= SUPERCLASS =========");
            Field[] superFields = c1.getSuperclass().getDeclaredFields();
            for (Field y:superFields) {
                System.out.println(Modifier.toString(y.getModifiers())+" "+y.getType()+" "+y.getName());
            }

            //get the class methods
            System.out.println("========= METHODS =========");
            Method[] methods = c1.getDeclaredMethods();

            for (Method y:methods) {
                System.out.println(Modifier.toString(y.getModifiers())+" "+y.getReturnType()+" "+y.getName());
            }

        }catch(ClassNotFoundException c){
            
        }
    }
}
