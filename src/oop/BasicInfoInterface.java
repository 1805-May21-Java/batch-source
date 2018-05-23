package oop;

// Abstraction uses interface:
public interface BasicInfoInterface {

	public void setName(String name);
	String getName();
	
	public void setAge(int years) throws Exception;
	int getAge();
	
}
