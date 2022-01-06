package com.revature.util;

import java.sql.*;

public class JDBCConnectionExample {
	
	static final String DB_URL = "jdbc:postgresql://localhost/postgres";
	static final String USER = "postgres";
	static final String PASS = "postgres123";
	static final String QUERY = "SELECT * FROM ers.ers_user_roles";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 System.out.println(conn);
	         Statement stmt = conn.createStatement();
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
                
		 }catch (SQLException e) {
		         e.printStackTrace();		 } 
	}

}
