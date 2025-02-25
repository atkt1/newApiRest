package com.api.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest{

	@JsonProperty("password")
	private String password;

	@JsonProperty("username")
	private String username;

	public LoginRequest(String admin, String password123) {
		setUsername(admin);
		setPassword(password123);
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"LoginRequest{" + 
			"password = '" + password + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}