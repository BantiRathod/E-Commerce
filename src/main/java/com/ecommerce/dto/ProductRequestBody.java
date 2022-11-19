package com.ecommerce.dto;

import java.util.Date;

public class ProductRequestBody {
	

    private  String name;
    private  String imageURL;
    private  double price;
    private  String description;
    private  Date createdAt;
    private  Integer categoryId;
	public ProductRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductRequestBody(String name, String imageURL, double price, String description, Date createdAt,
			Integer categoryId) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.createdAt = createdAt;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "ProductRequestBody [name=" + name + ", imageURL=" + imageURL + ", price=" + price + ", description="
				+ description + ", createdAt=" + createdAt + ", categoryId=" + categoryId + "]";
	}
	
    
    


}
