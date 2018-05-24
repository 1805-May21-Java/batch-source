package questions;

import java.util.Comparator;

//Incomplete
public class Q7Employee implements Comparator<Q7Employee>{
	private String name;
	private String department;
	private int age;
	
	
	public Q7Employee() {
		super();
	}
	
	public Q7Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}


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



	
	@Override
	public int compare(Q7Employee o1, Q7Employee o2) {
		int result = 0;
		result += o1.name.compareTo(o2.name);
		result += o1.department.compareTo(o2.department);
		if(o1.age > o2.age) {
			result += 1;
		}else if(o1.age < o2.age){
			result -= 1;
		}
		return result;
	}
	


	@Override
	public String toString() {
		return "Q7Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
