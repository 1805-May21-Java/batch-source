package com.revature.question11;

import com.revature.remoteData.*;

public class QuestionElvenDriver extends RemoteDataStorage
{
	public static void main(String[] args)
	{
		RemoteDataStorage rds = new RemoteDataStorage();
		System.out.println("First value: " + rds.getDataElementOne());
		System.out.println("Second value: " + rds.getDataElementTwo());
	}
}
