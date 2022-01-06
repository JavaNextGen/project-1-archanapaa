package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryReimbursementTest {
	
	static final String QUERY = "SELECT * FROM ers.ers_reimbursement";

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
	           System.out.print("reimb_id: " + rs.getInt("reimb_id"));
	           System.out.println("\n");
	           System.out.print("reimb_amount: " + rs.getDouble("reimb_amount"));
	           System.out.println("\n");
	           System.out.print("reimb_submitted: " + rs.getDate("reimb_submitted"));
	           System.out.println("\n");
	           System.out.print("reimb_resolved: " + rs.getDate("reimb_resolved"));
	           System.out.println("\n");
	           System.out.print("reimb_description: " + rs.getString("reimb_description"));
	           System.out.println("\n");
	           System.out.print("reimb_author: " + rs.getString("reimb_author"));
	           System.out.println("\n");
	           System.out.print("reimb_resolver: " + rs.getString("reimb_resolver"));
	           System.out.println("\n");
	         
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
