package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Request;

public interface RequestDAO {

	public ArrayList<Request> getRequests();
	public ArrayList<Request> getPendingRequests();
	public ArrayList<Request> getApprovedRequests();
	public ArrayList<Request> getPendingEmployeeRequests(int id);
	public ArrayList<Request> getApprovedEmployeeRequests(int id);
	public void updateRequest(int id, int manid);
	public void submitNewRequest(double d, int i, String description);
}
