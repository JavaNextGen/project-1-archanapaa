package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryReimbursementTypeTest {
	
	static final String QUERY = "SELECT * FROM ers.ers_reimbursement_type";

	public static void main(String[] args) {
		
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
	           System.out.print("reimbursement_type_id: " + rs.getInt("reimbursement_type_id"));
	           System.out.println("\n");
	           System.out.print("reimbursement_type " + rs.getString("reimbursement_type"));
	           System.out.println("\n");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
