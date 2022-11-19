package com.ecommerce.dto;

import java.util.Date;
import java.util.Set;

import com.ecommerce.Entities.Product;

public class CategoryRequestBody {
	private String categoryName;

	private String description;

	private String imageUrl;
	
	private Date createdAt;
	
	Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public CategoryRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryRequestBody(String categoryName, String description, String imageUrl, Date createdAt) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "CategoryRequestBody [categoryName=" + categoryName + ", description=" + description + ", imageUrl="
				+ imageUrl + ", createdAt=" + createdAt + "]";
	}
	
	

}
