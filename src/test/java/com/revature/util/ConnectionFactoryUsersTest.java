package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryUsersTest {
	
	static final String QUERY = "SELECT * FROM ers.ers_users";

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
	           System.out.print("ers_user_id: " + rs.getInt("ers_user_id"));
	           System.out.println("\n");
	           System.out.print("ers_user_name: " + rs.getString("ers_user_name"));
	           System.out.println("\n");
	           System.out.print("user_first_name: " + rs.getString("user_first_name"));
	           System.out.println("\n");
	           System.out.print("user_last_name: " + rs.getString("user_last_name"));
	           System.out.println("\n");
	           System.out.print("user_email: " + rs.getString("user_email"));
	           System.out.println("\n");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
