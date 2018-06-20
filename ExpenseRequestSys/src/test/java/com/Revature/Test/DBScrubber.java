package com.Revature.Test;

import java.sql.Connection;
import java.sql.Statement;

import com.Revature.util.ConnectionUtil;

public class DBScrubber {
	private static final String CLEAR_REQUESTS = "DELETE FROM EXPENSE_REQUEST";
	private static final String CLEAR_EMPLOYEES = "DELETE FROM EMPLOYEE";
	private static final String DROP_SEQUENCE = "DROP SEQUENCE SQ_EXPENSE_REQUEST_ID";
	private static final String CREATE_SEQUENCE = "CREATE SEQUENCE SQ_EXPENSE_REQUEST_ID START WITH 1 INCREMENT BY 1";

	public static boolean scrub() {
		boolean rval = true;

		try (Connection con = ConnectionUtil.getConnection()) {
			Statement stmt = con.createStatement();
			stmt.addBatch(CLEAR_REQUESTS);
			stmt.addBatch(CLEAR_EMPLOYEES);
			stmt.addBatch(DROP_SEQUENCE);
			stmt.addBatch(CREATE_SEQUENCE);

			stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rval = false;
		}

		return rval;
	}

	public static void main(String args[]) {
		System.out.println(scrub());
	}
}
