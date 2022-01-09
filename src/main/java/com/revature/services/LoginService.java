package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.LoginDAO;

public class LoginService {
	
	LoginDAO loginDao = new LoginDAO();
	
	public User authenticateUser(String username, String password) {

		User user = loginDao.authenticateEmployee(username, password);
		return user;
	}
	

}
