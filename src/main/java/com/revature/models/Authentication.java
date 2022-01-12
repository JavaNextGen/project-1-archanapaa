 package com.revature.models;

public class Authentication {
	private String username;
	private String password;
	private Boolean authenticationSuccessfull;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAuthenticationSuccessfull() {
		return authenticationSuccessfull;
	}
	public void setAuthenticationSuccessfull(Boolean authenticationSuccessfull) {
		this.authenticationSuccessfull = authenticationSuccessfull;
	}
	
	
}
