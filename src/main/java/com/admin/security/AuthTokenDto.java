package com.admin.security;

public class AuthTokenDto {

	private String token;

	public AuthTokenDto() {

	}

	public AuthTokenDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
