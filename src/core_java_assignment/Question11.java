package core_java_assignment;

import java.lang.reflect.Field;

public class Question11 {
//	private float float1, float2;
	public void retrieveFloats() {
		try {
			Class targetClass = Class.forName("core_java_assignment.package11.ForeignFloats");
			Field float1 = targetClass.getDeclaredField("float1");
			Field float2 = targetClass.getDeclaredField("float2");
			float1.setAccessible(true);
			float2.setAccessible(true);
			System.out.println(float2.get(targetClass.newInstance()));
		}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
