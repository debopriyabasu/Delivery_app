package com.delivery.user.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User 
{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int UserID;

	@Column(nullable = false)
	private String username;
	
	private	int contactno;
	
	@Column(nullable = false)
	private	String email;
	

	@Column(nullable = false)
	private	String password;
	
	private	String address;
	

	@Column(nullable = false)
	private	String Role; //ADMIN , USER
	
	public int getUserID() {
		return UserID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	
}
