package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReimbursementInterface;

public class ReimbursementDao implements ReimbursementInterface{
	private String createReimbursement = "INSERT INTO REIMBURSEMENT (reimbursementId, employeeId, reimbursementValue, reimbursementReason, status) values (SEQ_PK_REIMBURSMENTID.nextval, ?, ?, ?, ?)";
	private String getReimbursementById = "SELECT * FROM REIMBURSEMENT where reimbursementId = ?";
	private String modifyReimbursement = "UPDATE REIMBURSEMENT SET status = ?, managerId = ? where reimbursementId = ?";
	
	public long createReimbursement(Connection connection, long employeeId,
			double reimbursementValue, long managerId, String reimbursementReason, int status) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(createReimbursement, new String[] {"reimbursementId"});
		ps.setLong(1, employeeId);
		ps.setDouble(2, reimbursementValue);
		ps.setString(3, reimbursementReason);
		ps.setInt(4, status);
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

	public void modifyReimbursement(Connection connection, long reimbursementId, long managerId, int status) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(modifyReimbursement);
		ps.setInt(1, status);
		ps.setLong(2, managerId);
		ps.setLong(3, reimbursementId);
		ps.executeUpdate();
	}

	public Reimbursement getReimbursementById(Connection connection, long reimbursementId) throws SQLException {
		Reimbursement reimbursement = null;
		PreparedStatement ps = connection.prepareStatement(getReimbursementById);
		ps.setLong(1, reimbursementId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursement = new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("dateSubmitted"));
		}
		return reimbursement;
	}

	public ArrayList<Reimbursement> getReimbursementByEmployeeId(Connection connection, long employeeId) throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE employeeId = ? ORDER BY reimbursementId");
		ps.setLong(1, employeeId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("dateSubmitted")));
		}
		return reimbursementList;
	}

	public ArrayList<Reimbursement> getAllReimbursement(Connection connection) throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT ORDER BY reimbursementId");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("dateSubmitted")));
		}
		return reimbursementList;
	}

	@Override
	public ArrayList<Reimbursement> getPendingReimbursement(Connection connection) throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 0 ORDER BY reimbursementId");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("datesubmitted")));
		}
		return reimbursementList;
	}

	@Override
	public ArrayList<Reimbursement> getPendingReimbursementByEmployeeId(Connection connection, long employeeId)
			throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 0 AND employeeId = ? ORDER BY reimbursementId");
		ps.setLong(1, employeeId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("datesubmitted")));
		}
		return reimbursementList;
	}

	@Override
	public ArrayList<Reimbursement> getDeniedReimbursementByEmployeeId(Connection connection, long employeeId)
			throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 1 AND employeeId = ? ORDER BY reimbursementId");
		ps.setLong(1, employeeId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("datesubmitted")));
		}
		return reimbursementList;
	}

	@Override
	public ArrayList<Reimbursement> getApprovedReimbursementByEmployeeId(Connection connection, long employeeId)
			throws SQLException {
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 2 AND employeeId = ? ORDER BY reimbursementId");
		ps.setLong(1, employeeId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			reimbursementList.add(new Reimbursement(rs.getLong("reimbursementId"), rs.getLong("employeeId"), rs.getDouble("reimbursementValue"), rs.getLong("managerId"), rs.getString("reimbursementReason"), rs.getInt("status"), rs.getDate("datesubmitted")));
		}
		return reimbursementList;
	}

}
