package com.revature.remoteData;

public class RemoteDataStorage 
{
	private float dataElementOne = (float)0.9;
	private float dataElementTwo = (float)6.7;
	
	public float getDataElementOne()
	{
		return dataElementOne;
	}

	public void setDataElementOne(float dataElementOne)
	{
		this.dataElementOne = dataElementOne;
	}

	public float getDataElementTwo()
	{
		return dataElementTwo;
	}

	public void setDataElementTwo(float dataElementTwo)
	{
		this.dataElementTwo = dataElementTwo;
	}

	public RemoteDataStorage()
	{
		super();
	}
}
