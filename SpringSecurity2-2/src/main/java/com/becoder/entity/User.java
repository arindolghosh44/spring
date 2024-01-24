package com.becoder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullName;
	
	private String email;
	
	private String mobileNumber;
	
	
	private String password;

	private String Role;

	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", password=" + password + ", Role=" + Role + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User(int id, String fullName, String email, String mobileNumber, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}


	public User() {
		super();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
