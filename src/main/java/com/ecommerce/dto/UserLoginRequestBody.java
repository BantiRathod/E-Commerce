package com.ecommerce.dto;

public class UserLoginRequestBody {
    
	private String userName;
	private String password;

	
	
	public UserLoginRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserLoginRequestBody(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}





	
}
