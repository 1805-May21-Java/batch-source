package game;

public class Associate implements Comparable<Associate>{
String name = "";

	
	
	public Associate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Associate(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Associate [name=" + name + "]";
	}

	@Override
	public int compareTo(Associate otherPerson) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(otherPerson.getName());
	}
	
	
}
