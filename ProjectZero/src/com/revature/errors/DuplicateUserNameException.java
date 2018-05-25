package com.revature.errors;

public class DuplicateUserNameException extends Throwable
{

	public DuplicateUserNameException()
	{
		super();
	}

	public DuplicateUserNameException(String message)
	{
		super(message);
	}

}
