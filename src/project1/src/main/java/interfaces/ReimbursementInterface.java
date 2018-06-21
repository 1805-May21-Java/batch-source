package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import data.Reimbursement;

public interface ReimbursementInterface {
	long createReimbursement(Connection connection, long employeeId, double reimbursementValue, long managerId, String reimbursementReason, int status) throws SQLException;
	void modifyReimbursement(Connection connection, long reimbursementId, long managerId, int status) throws SQLException;
	Reimbursement getReimbursementById(Connection connection, long reimbursementId) throws SQLException;
	ArrayList<Reimbursement> getReimbursementByEmployeeId(Connection connection, long employeeId) throws SQLException;
	ArrayList<Reimbursement> getPendingReimbursementByEmployeeId(Connection connection, long employeeId) throws SQLException;
	ArrayList<Reimbursement> getDeniedReimbursementByEmployeeId(Connection connection, long employeeId) throws SQLException;
	ArrayList<Reimbursement> getApprovedReimbursementByEmployeeId(Connection connection, long employeeId) throws SQLException;
	ArrayList<Reimbursement> getPendingReimbursement(Connection connection) throws SQLException;
	ArrayList<Reimbursement> getAllReimbursement(Connection connection) throws SQLException;
}
