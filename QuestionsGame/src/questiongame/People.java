package questiongame;

//class for associates
public class People {

	String name;


	public People() {
		super();
	}

	public People(String name) {
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
		return this.name;
	}
	
}
