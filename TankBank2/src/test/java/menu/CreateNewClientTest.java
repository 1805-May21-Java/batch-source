package menu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import junit.framework.Assert;
public class CreateNewClientTest {

		
	
	
	@Test
	public void freeUsername(){
		//Method to access the userNameTaken class
		try {
			Class createNewClient = Class.forName("com.revature.menu.CreateNewClient");
			try {
				Method method = createNewClient.getDeclaredMethod("userNameTaken",String.class);
				method.setAccessible(true);
				//Checks if username is taken, should be false 
					boolean result = (boolean)method.invoke(boolean.class, "hiiiii");
					assert(!result);

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	

	@Test
	public void takenUsername(){
		//Method to access the userNameTaken class
		try {
			Class createNewClient = Class.forName("com.revature.menu.CreateNewClient");
			try {
				Method method = createNewClient.getDeclaredMethod("userNameTaken",String.class);
				method.setAccessible(true);
				//Checks if username is taken, should be true 
					boolean result = (boolean) method.invoke(boolean.class, "Jay");

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}