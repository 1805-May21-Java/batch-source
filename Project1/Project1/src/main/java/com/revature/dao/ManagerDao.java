package com.revature.dao;

import com.revature.pojos.Manager;

public interface ManagerDao {
	public Manager getManager(String email, String password);
}
