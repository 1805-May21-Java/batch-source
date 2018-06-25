package com.revature.banking.pojos;

import com.revature.banking.dao.AccessImpl;

public class Access extends AccessImpl{

	public Access() {
		super();
	}

	@Override
	public String toString() {
		return "Access [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
