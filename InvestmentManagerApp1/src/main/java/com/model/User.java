package com.model;

public class User {
	String Username;
	String password;
	String email;
	String contact;

	
	public User() {
		super();
	}

	
	public User(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}

	public User(String username, String password, String email, String contact) {
		super();
		Username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}

	

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}


