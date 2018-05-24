package com.revature.algorithms;

import java.lang.reflect.Field;
import com.revature.other.Weird;

public class Access {
	
	public Access() {
		super();
	}
	
	public static void accessFloats(Weird obj, float f1, float f2) {
		try {
			Class weird = Class.forName("com.revature.other.Weird");
			Field[] fields = weird.getDeclaredFields();
			fields[0].setAccessible(true);
			fields[0].set(obj, f1);
			fields[0].setAccessible(false);
			fields[1].setAccessible(true);
			fields[1].set(obj, f2);
			fields[1].setAccessible(false);
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
