package com.ecommerce.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ecommerce.Entities.Address;

public class UserRegisterRequestBody {
	@Email(message = "invalid email address")
	private String email;
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	@NotEmpty
	@Size(min = 2, message = "First name should have at least 2 characters")
	private String firstName;
	@Size(min = 2, message = "First name should have at least 2 characters")
	private String lastName;
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String mobileNumber;

	
	private List<Address> adresses;

	public UserRegisterRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegisterRequestBody(@Email String email, String password, String firstName, String lastName,
			String mobileNumber, List<Address> adresses) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.adresses = adresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "UserRegisterRequestBody [email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", adresses=" + adresses + "]";
	}
	
	
	
	

}
