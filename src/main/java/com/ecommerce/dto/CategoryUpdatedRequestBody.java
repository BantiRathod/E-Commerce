package com.ecommerce.dto;

import java.util.Date;
import java.util.Set;

import com.ecommerce.Entities.Product;

public class CategoryUpdatedRequestBody {
	private String categoryName;

	private String description;

	private String imageUrl;
	
	private Date updatedAt;
	
	Set<Product> products;

	public CategoryUpdatedRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryUpdatedRequestBody(String categoryName, String description, String imageUrl, Date updatedAt) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.updatedAt = updatedAt;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
	

}
