package com.revature.reflection;

import com.revature.beans.Bicycle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

            System.out.println("Making new instance of bicycle.");
            Bicycle b1 = (Bicycle) c1.newInstance();
            System.out.println(b1.toString()+"\n");

            //Manipulating the fields within an object.
            Field hasWheels = c1.getDeclaredField("wheels");
            hasWheels.setAccessible(true);
            hasWheels.set(b1, 3);

            Method speedUpMethod = c1.getDeclaredMethod("SpeedUp");
            speedUpMethod.invoke(b1,10);


        }catch (ClassNotFoundException c){
            
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
