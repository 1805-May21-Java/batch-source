import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Comparison;

public class Q7 implements Comparable<Q7>{
//This class defines the employee class, if I didn't want to label each file by their question number
//then this class would be called Empolyee
	String name;
	int age;
	String department;
	
	public Q7() {
		super();
	}
	
	public Q7(String name, int age, String department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}


	public static void main(String[] args) {
		Q7 Aiden = new Q7("Aidenee",20,"home improvement");
		Q7 Aiden2 = new Q7("Aiden",20,"home improvement");
		System.out.println(Aiden.compareTo(Aiden2));
		
	}

	//Compares first by name, then age, then department
	@Override
	public int compareTo(Q7 other) {
		//Compares string by the built-in compareTo method of strings
		if(this.name.compareTo(other.name) != 0) {
			return this.name.compareTo(other.name);
		//if the compator is 0, then move on to camparing by age
		}else if(this.age > other.age) {
			return 1;
		}else if(this.age < other.age) {
			return -1;
		}else if (this.department.compareTo(other.department) != 0) { //if it reaches here ages are equal, compare by dpt
			return this.department.compareTo(other.department);
		}else {
			//ages are equal, every field is equal
			return 0;
		}
	}
	
	

}

