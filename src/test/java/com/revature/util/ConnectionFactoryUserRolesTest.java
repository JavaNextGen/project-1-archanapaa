package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryUserRolesTest {
	
	static final String QUERY = "SELECT * FROM ers.ers_user_roles";

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
	           System.out.print("user role id: " + rs.getInt("ers_user_role_id"));
	           System.out.println("\n");
	           System.out.print("user role: " + rs.getString("user_role"));
	           System.out.println("\n");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
