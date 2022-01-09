package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class LoginDAO {

	// Bit more complicated query, uses a join to get more data than usual from two
	// tables
	public User authenticateEmployee(String username, String password) {

		User user = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			ResultSet rs = null;

			String sql = "SELECT eu.ers_user_id, eu.ers_user_name, eu.user_password, eur.user_role \r\n"
					+ "FROM ers.ers_users eu, ers.ers_user_roles eur \r\n"
					+ "WHERE ers_user_name=? AND user_password=? \r\n"
					+ "AND eu.ers_user_role_id = eur.ers_user_role_id \r";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			System.out.println(rs);

			if (rs.next()) {
				Role role = null;
				if (rs.getString("user_role").equalsIgnoreCase("Employee")) {
					role = Role.EMPLOYEE;
				} else {
					role = Role.FINANCE_MANAGER;
				}

				user = new User(rs.getInt("ers_user_id"), rs.getString("ers_user_name"), rs.getString("user_password"),
						role);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return user;
	}

}
