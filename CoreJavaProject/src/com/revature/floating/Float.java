package com.revature.floating;

public class Float 
{

	private float float1, float2;

	public Float() 
	{
		super();
	}

	public Float(float float1, float float2) 
	{
		super();
		this.float1 = float1;
		this.float2 = float2;
	}

	public float getFloat1() 
	{
		return float1;
	}

	public void setFloat1(float float1) 
	{
		this.float1 = float1;
	}

	public float getFloat2() 
	{
		return float2;
	}

	public void setFloat2(float float2) 
	{
		this.float2 = float2;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + java.lang.Float.floatToIntBits(float1);
		result = prime * result + java.lang.Float.floatToIntBits(float2);
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Float other = (Float) obj;
		if (java.lang.Float.floatToIntBits(float1) != java.lang.Float.floatToIntBits(other.float1))
			return false;
		if (java.lang.Float.floatToIntBits(float2) != java.lang.Float.floatToIntBits(other.float2))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Float [float1=" + float1 + ", float2=" + float2 + "]";
	}
	
}
