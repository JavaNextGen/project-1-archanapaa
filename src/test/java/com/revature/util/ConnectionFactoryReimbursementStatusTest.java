package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryReimbursementStatusTest {
	
	static final String QUERY = "SELECT * FROM ers.ers_reimbursement_status";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		System.out.println(conn);
		Statement stmt;
		try {
			stmt = conn.createStatement();
		
	        ResultSet rs = stmt.executeQuery(QUERY);
	        System.out.println(rs);
	        System.out.println("\n");
	        // Extract data from result set
	        while (rs.next()) {
	           // Retrieve by column name
	           System.out.print("reimb_status_id: " + rs.getInt("reimb_status_id"));
	           System.out.println("\n");
	           System.out.print("reimb_status: " + rs.getString("reimb_status"));
	           System.out.println("\n");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
