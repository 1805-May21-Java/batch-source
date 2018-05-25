package com.Revature.HackMe;

public class Car {
	//Two private float fields
	private float miles;
	private float mpg;

	//Generic Car POJO
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(float miles, float mpg) {
		super();
		this.miles = miles;
		this.mpg = mpg;
	}

	public float getMiles() {
		return miles;
	}

	public void setMiles(float miles) {
		this.miles = miles;
	}

	public float getMpg() {
		return mpg;
	}

	public void setMpg(float mpg) {
		this.mpg = mpg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(miles);
		result = prime * result + Float.floatToIntBits(mpg);
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
		Car other = (Car) obj;
		if (Float.floatToIntBits(miles) != Float.floatToIntBits(other.miles))
			return false;
		if (Float.floatToIntBits(mpg) != Float.floatToIntBits(other.mpg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [miles=" + miles + ", mpg=" + mpg + "]";
	}

}
