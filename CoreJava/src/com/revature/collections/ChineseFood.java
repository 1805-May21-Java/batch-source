package com.revature.collections;

public class ChineseFood implements Comparable<ChineseFood> {
	
	private boolean hasMSG;
	private int calories;
	private float price;
	private String name;
	
	public ChineseFood() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChineseFood(boolean hasMSG, int calories, float price, String name) {
		super();
		this.hasMSG = hasMSG;
		this.calories = calories;
		this.price = price;
		this.name = name;
	}

	public boolean isHasMSG() {
		return hasMSG;
	}

	public void setHasMSG(boolean hasMSG) {
		this.hasMSG = hasMSG;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
		result = prime * result + (hasMSG ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		ChineseFood other = (ChineseFood) obj;
		if (calories != other.calories)
			return false;
		if (hasMSG != other.hasMSG)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChineseFood [hasMSG=" + hasMSG + ", calories=" + calories + ", price=" + price + ", name=" + name + "]";
	}

	@Override
	public int compareTo(ChineseFood o) {
		//return this.getCalories()-o.getCalories();
		return this.getName().compareTo(o.getName());
	}
	//returning a positive number indicates "this" has a greater value than the parameter object
	//returning a negative number indicates "this" has a lesser value than the parameter object
	
	
	

}
