package com.revature.q11.accessor;

import java.lang.reflect.*;
import java.util.Random;

import com.revature.q11.floats.OutsideClass;


public class Driver {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.revature.q11.floats.OutsideClass");
			
			OutsideClass os = (OutsideClass) c.newInstance();
			
			System.out.println(os.toString());
			
			Field f1 = c.getDeclaredField("f1");
			Field f2 = c.getDeclaredField("f2");
			
			
			f1.setAccessible(true);
			f2.setAccessible(true);
						
			Random r = new Random();
			f1.set(os, r.nextFloat() * 100);
			f2.set(os, r.nextFloat() * 100);
			
			f1.setAccessible(false);
			f2.setAccessible(false);
			
		
			
			System.out.println(os.toString());
			
			
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
		}
	}
}
