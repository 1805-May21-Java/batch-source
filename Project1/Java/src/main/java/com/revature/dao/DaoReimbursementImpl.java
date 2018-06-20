package com.revature.dao;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.ERSContract;

public class DaoReimbursementImpl implements DaoReimbursement {

	public ArrayList<Reimbursement> getReimbursementByEmployee(int employeeId) {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", 
					ERSContract.REIMBURSEMENT_TABLE_NAME,ERSContract.EMPLOYEE_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				reimbursementList.add(new Reimbursement(
						resultSet.getInt(ERSContract.REIMBURSEMENT_ID),
						resultSet.getString(ERSContract.REIMBURSEMENT_NAME),
						resultSet.getDouble(ERSContract.REIMBURSEMENT_AMOUNT),
						resultSet.getInt(ERSContract.REIMBURSEMENT_STATUS),
						resultSet.getString(ERSContract.REIMBURSEMENT_DESCRIPTION),
						employeeId));
			}
			return reimbursementList;
		} catch (SQLException | IOException e) {
			
		}
		return null;
	}

	public ArrayList<Reimbursement> getPendingReimbursements() {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", 
					ERSContract.REIMBURSEMENT_TABLE_NAME,ERSContract.REIMBURSEMENT_STATUS);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ERSContract.PENDING);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				reimbursementList.add(new Reimbursement(
						resultSet.getInt(ERSContract.REIMBURSEMENT_ID),
						resultSet.getString(ERSContract.REIMBURSEMENT_NAME),
						resultSet.getDouble(ERSContract.REIMBURSEMENT_AMOUNT),
						resultSet.getInt(ERSContract.REIMBURSEMENT_STATUS),
						resultSet.getString(ERSContract.REIMBURSEMENT_DESCRIPTION),
						resultSet.getInt(ERSContract.REIMBURESMENT_EMPLOYEE_ID)));
			}
			return reimbursementList;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateOldReimbursement(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
					ERSContract.REIMBURSEMENT_TABLE_NAME,
					ERSContract.REIMBURSEMENT_NAME,
					ERSContract.REIMBURSEMENT_AMOUNT,
					ERSContract.REIMBURSEMENT_DESCRIPTION,
					ERSContract.REIMBURSEMENT_STATUS,
					ERSContract.REIMBURSEMENT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reimbursement.getName());
			preparedStatement.setDouble(2, reimbursement.getReimbursementAmount());
			preparedStatement.setString(3, reimbursement.getDescription());
			preparedStatement.setInt(4, reimbursement.getStatus());
			preparedStatement.setInt(5, reimbursement.getReimbursementId());
			return preparedStatement.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewReimbursement(Reimbursement reimbursement) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("BEGIN INSERT INTO %s (%s, %s, %s, %s, %s) VALUES(?,?,?,?,?)"
					+ " RETURNING %s INTO ?;END;", 
					ERSContract.REIMBURSEMENT_TABLE_NAME,
					ERSContract.REIMBURSEMENT_NAME,
					ERSContract.REIMBURSEMENT_AMOUNT,
					ERSContract.REIMBURSEMENT_STATUS,
					ERSContract.REIMBURSEMENT_DESCRIPTION,
					ERSContract.EMPLOYEE_ID,
					ERSContract.REIMBURSEMENT_ID);
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, reimbursement.getName());
			callableStatement.setDouble(2, reimbursement.getReimbursementAmount());
			callableStatement.setInt(3, reimbursement.getStatus());
			callableStatement.setString(4, reimbursement.getDescription());
			callableStatement.setInt(5, reimbursement.getEmployeeId());
			callableStatement.registerOutParameter(6, Types.NUMERIC);
			callableStatement.execute();
			return callableStatement.getInt(6);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Reimbursement getReimbursementById(int reimburesmentId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?",
					ERSContract.REIMBURSEMENT_TABLE_NAME,ERSContract.REIMBURSEMENT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reimburesmentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return new Reimbursement(
						reimburesmentId,
						resultSet.getString(ERSContract.REIMBURSEMENT_NAME),
						resultSet.getDouble(ERSContract.REIMBURSEMENT_AMOUNT),
						resultSet.getInt(ERSContract.REIMBURSEMENT_STATUS),
						resultSet.getString(ERSContract.REIMBURSEMENT_DESCRIPTION),
						resultSet.getInt(ERSContract.REIMBURESMENT_EMPLOYEE_ID));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteReimbursementById(int remibursementId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("DELETE FROM %s WHERE %s = ?", 
					ERSContract.REIMBURSEMENT_TABLE_NAME,ERSContract.REIMBURSEMENT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, remibursementId);
			return preparedStatement.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
