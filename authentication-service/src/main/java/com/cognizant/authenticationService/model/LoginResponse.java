package com.cognizant.authenticationService.model;

public class LoginResponse {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginResponse(String token) {
		super();
		this.token = token;
	}
	
	
	
}
