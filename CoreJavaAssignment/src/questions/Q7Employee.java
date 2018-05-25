package questions;

import java.util.Comparator;

//Program implements the Comparator interface and overrides
//method compare(Q7Employee e1, Q7Employee e2)
public class Q7Employee implements Comparator<Q7Employee>{
	//Member variables to sort Q7Employee objects
	private String name;
	private String department;
	private int age;
	
	
	//Constructors
	public Q7Employee() {
		super();
	}
	
	public Q7Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	//Getters and Setters included for Q7Employee
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//compare returns result of comparison between Q7Employee
	//objects e1 and e2.
	@Override
	public int compare(Q7Employee e1, Q7Employee e2) {
		//int result will be the sum of each comparison between
		//both object's member variables
		int result = 0;
		//.compareTo returns an int, which is used
		//to add to result
		result += e1.name.compareTo(e2.name);
		result += e1.department.compareTo(e2.department);
		//if-else if makes sure that if either e1 or e2's age variable
		//is greater than the other, it adds to result
		if(e1.age > e2.age) {
			result += 1;
		}else if(e1.age < e2.age){
			result -= 1;
		}
		//result from comparison is returned.
		return result;
	}
	
	//.toString() has been overridden to allow Driver to print out object.
	@Override
	public String toString() {
		return "Q7Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
