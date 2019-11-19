package com.admin.security;

public class LoginUserDto {

	private String username;
	private String password;
	private Long rol;
	

	public Long getRol() {
		return rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
	}

	public LoginUserDto() {

	}

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

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

}
