package com.revature.dao;

import com.revature.pojos.Manager;

public interface daoManager {
	public Manager getManagerById(int managerId);
	public boolean updateOldManager(Manager manager);
	public int insertNewManager(Manager manager);
	public Manager managerLogin(String email, String password);
	public boolean deleteManagerById(int id);
	public boolean deletAllEmployees(int id);
}
