import java.lang.reflect.Field;


public class Q11 {

	public static void main(String[] args) {

		//uses reflection to get the class in a different package
		//Other variable static, so accessible without creating an object
		try {
			Class class1 = Class.forName("packageforq11.ClassForQ11");
			Field firstFloat = (class1.getDeclaredField("num1"));
			//variable set to private, so need to change accessibility
			firstFloat.setAccessible(true);
			//print to show that I have access to the value
			System.out.println(firstFloat.get(class1));
			//repeat for second variable
			Field secondFloat = (class1.getDeclaredField("num2"));
			secondFloat.setAccessible(true);
			System.out.println(secondFloat.get(class1));
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
