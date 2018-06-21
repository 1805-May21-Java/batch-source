package dao;

import java.util.ArrayList;

import model.Manager;

public interface ManagerDAO {

	public Manager getManagerById(int id);
	public String getManagerByEmail(String email);
	public ArrayList<Manager> getManagers();
	public int getManagerIdByEmail(String email);
}
