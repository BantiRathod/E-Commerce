package com.ecommerce.dto;

import java.util.Date;

public class UserUpdateRequestBody {
	
	private String password;
	private String firstName;
	private String lastName;
	
	private Date updatedAt;
	public UserUpdateRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateRequestBody(String password, String firstName, String lastName, Date updatedAt) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.updatedAt = updatedAt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
