package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.revature.beans.Bicycle;

public class ReflectionDriver {
	public static void main(String[] args) {
		try {
			Class c1 = Class.forName("com.revature.beans.Bicycle");
			System.out.println("Class: "+ c1.getName());
			System.out.println();
			
			System.out.println("Fields: ");
			Field[] fields = c1.getDeclaredFields();
			for(Field field: fields){
				System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+ " "+field.getName());
			}
			
			Field[] superfields = c1.getSuperclass().getDeclaredFields();
			for(Field field: superfields) {
				System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
			}
			
			System.out.println();
			System.out.println("Methods: ");
			Method[] methods = c1.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method.toString());
			}
			
			System.out.println();
			Bicycle b1 = (Bicycle) c1.newInstance();
			System.out.println("Instance of bicycle created by reflection");
			System.out.println(b1.toString());
			System.out.println();
			
			Field hasKickStandField = c1.getDeclaredField("kickStand");
			hasKickStandField.setAccessible(true);
			hasKickStandField.set(b1, true);
			System.out.println("We can even then change the fields within that object");
			System.out.println(b1.toString());
			System.out.println();
			
			//Use a method within the class
			Method speedUpMethod = c1.getDeclaredMethod("speedUp", int.class);
			System.out.println("We can invoke methods from classes!");
			speedUpMethod.invoke(b1, 10);
			System.out.println(b1.toString());
			
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
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
