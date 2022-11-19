package com.ecommerce.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressRequestBody {
	
	@NotEmpty
	@Size(min = 2, message = "City name should have at least 2 characters")
	private String city;
	@NotNull(message = " house Number should have at least 3 digits")
	private int houseNumber;
	@NotEmpty
	@Size(min = 2, message = "street name should have at least 2 characters")
	private String street;
	@NotNull( message = "pincode should have at least 6 digits")
	@Pattern(regexp = "^[1-9][0-9]{5}$")
	private String pincode;
	public AddressRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressRequestBody( String city, int houseNumber, String street, String pincode) {
		super();
		this.city = city;
		this.houseNumber = houseNumber;
		this.street = street;
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
