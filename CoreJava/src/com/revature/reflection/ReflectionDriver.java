package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.revature.beans.Bicycle;

public class ReflectionDriver {

	public static void main(String[] args) {
		
		
		try {
			//getting our class
			Class c1 = Class.forName("com.revature.beans.Bicycle");
			System.out.println("Class: "+ c1.getName());
			System.out.println();
			
			//get the class's fields
			System.out.println("Fields:");
			Field[] fields = c1.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
			}
			Field[] superFields = c1.getSuperclass().getDeclaredFields();
			for(Field field : superFields) {
				System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
			}
			System.out.println();
			 
			//get the class's methods
			System.out.println("Methods:");
			Method[] methods = c1.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method.toString());
			}
//			System.out.println("Generic string:");
//			for(Method method : methods) {
//				System.out.println(method.toGenericString());
//			}
			System.out.println();
			
			//we can create an instance of a Bicycle using only its class
			Bicycle b1 = (Bicycle) c1.newInstance();
			//this will need a no args constructor our Bicycle class
			//otherwise we get a NoSuchMethodException and a InstantiationException
			System.out.println("Instance of Bicycle created by reflection");
			System.out.println(b1.toString());
			System.out.println();
			
			//we also have the capability of manipulating the fields within these objects
			Field hasKickstandField = c1.getDeclaredField("hasKickstand");
			hasKickstandField.setAccessible(true);
			hasKickstandField.set(b1, true);
			hasKickstandField.setAccessible(false);
			System.out.println("We can even then change the fields within that object");
			System.out.println(b1.toString());
			System.out.println();
			
			//use a method within the class
			Method speedUpMethod = c1.getDeclaredMethod("speedUp", int.class);
			System.out.println("We can also invoke methods from our classes");
			speedUpMethod.invoke(b1, 10);
			System.out.println(b1.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
