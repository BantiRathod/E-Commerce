package com.ecommerce.dto;

import java.util.Date;

public class ProductUpdateRequestBody {
	private  String name;
    private  String imageURL;
    private  double price;
    private  String description;
    private  Date updatedAt;
    private  Integer categoryId;
	public ProductUpdateRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductUpdateRequestBody(String name, String imageURL, double price, String description, Date updatedAt,
			Integer categoryId) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.updatedAt = updatedAt;
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "ProductUpdateRequestBody [name=" + name + ", imageURL=" + imageURL + ", price=" + price
				+ ", description=" + description + ", updatedAt=" + updatedAt + ", categoryId=" + categoryId + "]";
	}
    
    

}
