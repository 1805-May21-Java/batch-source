package com.revature.fileio;

import java.io.Serializable;

public class Cereal implements Serializable {

	/**
	 * POJO (Plain Old Java Object)
	 * - private instance fields
	 * - public getters and setters
	 * - no args constructor
	 * - override equals()
	 * - override hashCode()
	 * - override toStringMethod
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private boolean hasMilk;
	private transient int calories;
	private boolean isWholeWheat;
	private String name;
	
	public Cereal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cereal(boolean hasMilk, int calories, boolean isWholeWheat, String name) {
		super();
		this.hasMilk = hasMilk;
		this.calories = calories;
		this.isWholeWheat = isWholeWheat;
		this.name = name;
	}

	public boolean isHasMilk() {
		return hasMilk;
	}

	public void setHasMilk(boolean hasMilk) {
		this.hasMilk = hasMilk;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isWholeWheat() {
		return isWholeWheat;
	}

	public void setWholeWheat(boolean isWholeWheat) {
		this.isWholeWheat = isWholeWheat;
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
		result = prime * result + calories;
		result = prime * result + (hasMilk ? 1231 : 1237);
		result = prime * result + (isWholeWheat ? 1231 : 1237);
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
		Cereal other = (Cereal) obj;
		if (calories != other.calories)
			return false;
		if (hasMilk != other.hasMilk)
			return false;
		if (isWholeWheat != other.isWholeWheat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cereal [hasMilk=" + hasMilk + ", calories=" + calories + ", isWholeWheat=" + isWholeWheat + ", name="
				+ name + "]";
	}

}
