package interfaces;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import data.Reimbursement;

public interface ReimbursementInterface {
	long createReimbursement(Connection connection, long reimbursementId, long employeeId, long reimbursementValue, long managerId, String reimbursementReason, boolean status);
	void modifyReimbursement(Connection connection, long reimbursementId, long managerId, boolean status);
	Reimbursement getReimbursementById(Connection connection, long reimbursementId);
	ArrayList<Reimbursement> getReimbursementByEmployeeId(Connection connection, long employeeId);
	ArrayList<Reimbursement> getAllReimbursement(Connection connection);
}
