package com.revature.dao;
//This DAO implementation will do all of them at once for my convenience
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import com.revature.pojos.*;
public interface FullDAO {
	public User verify(String username, String password);
	public User getUserByName(String username);
	public boolean updateUser(User u);
	public boolean rejectRequest(int requester_id, int resolver_id);
	public boolean approveRequest(int requester_id, int resolver_id);
	public List<Reimbursement> getPendings(int emp_id);
	public List<Reimbursement> getResolveds(int emp_id);
	public List<Reimbursement> getPendings();
	public List<Reimbursement> getResolveds();
	public List<User> listEmployees();
	public boolean createUser(String username, String password, String fname, String lname, String email, Role r);
	public boolean createRequest(double amount, String descript, InputStream receipt, int user_id, ReimbursementType type);
	public void getReceipt(int receipt_id, OutputStream out);
	public void getReceipt(int user_id, int receipt_id, OutputStream out);
}
