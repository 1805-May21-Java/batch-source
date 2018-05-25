package com.revature.question;

public class Associates {
	private String name;

	public Associates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Associates(String name) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associates otherAssoc = (Associates) obj;
		if (name == null) {
			if (otherAssoc.name != null)
				return false;
		} else if (!name.equals(otherAssoc.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Associate " + name;
	}
	
}