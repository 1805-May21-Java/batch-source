package pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.Revature.util.ConnectionUtil;

public class DBScrub {
	/*
	 * Define all strings for clearing and setting up database
	 * Used just for unit testing
	 * Sequence is also reset to start at 0
	 */
	
	private static String CLEAR_LINK = "DELETE FROM PROFILE_ACCOUNT"; 
	private static String CLEAR_ACCOUNT = "DELETE FROM BANK_ACCOUNT";
	private static String CLEAR_PROFILE = "DELETE FROM USER_PROFILE";
	private static String DROP_SEQUENCE = "DROP SEQUENCE SQ_BANK_ACCOUNT_NUMBER";
	private static String CREATE_SEQUENCE = "CREATE SEQUENCE SQ_BANK_ACCOUNT_NUMBER\r\n" + 
			"START WITH 0\r\n" + 
			"MINVALUE 0\r\n" + 
			"INCREMENT BY 1";

	public static boolean scrub() {
		boolean rval = true;
		try (Connection con = ConnectionUtil.getConnection()) {
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			stmt.addBatch(CLEAR_LINK);
			stmt.addBatch(CLEAR_ACCOUNT);
			stmt.addBatch(CLEAR_PROFILE);
			stmt.addBatch(DROP_SEQUENCE);
			stmt.addBatch(CREATE_SEQUENCE);
			stmt.executeBatch(); //Executes series or statements

			con.commit();
		} catch (SQLException e) {
			rval = false;
			e.printStackTrace();
		} catch (IOException e) {
			rval = false;
			e.printStackTrace();
		}

		return rval;
	}
	
	public static void main(String args[]) { //Can run this as a stand alone
		if ( scrub()) {
			System.out.println("Scrub ok");
		}
	}
}
