package data;

import java.sql.Connection;
import java.util.ArrayList;

import interfaces.ReimbursementInterface;

public class ReimbursementDao implements ReimbursementInterface{

	public long createReimbursement(Connection connection, long reimbursementId, long employeeId,
			long reimbursementValue, long managerId, String reimbursementReason, boolean status) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void modifyReimbursement(Connection connection, long reimbursementId, long managerId, boolean status) {
		// TODO Auto-generated method stub
		
	}

	public Reimbursement getReimbursementById(Connection connection, long reimbursementId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Reimbursement> getReimbursementByEmployeeId(Connection connection, long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Reimbursement> getAllReimbursement(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

}
