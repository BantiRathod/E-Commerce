package com.ecommerce.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Category;
import com.ecommerce.dto.CategoryRequestBody;
import com.ecommerce.dto.CategoryUpdatedRequestBody;
import com.ecommerce.repositories.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Category> getCategoryByCategoryName(String categoryName) {

		return categoryRepo.findByCategoryName(categoryName);
	}

	public Category createCategory(CategoryRequestBody category) {
		Category temp = new Category();
		temp.setCategoryName(category.getCategoryName());
		temp.setImageUrl(category.getImageUrl());
		temp.setDescription(category.getDescription());
		temp.setCreatedAt(new Date());
		temp.setUpdatedAt(new Date());
		temp.setProducts(category.getProducts());
		
		
		return categoryRepo.save(temp); 

	}

	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	public Category findByCategoryId(Integer categoryID) {

		return categoryRepo.findById(categoryID).get();
	}

	public Category updateCategory(Integer categoryID, CategoryUpdatedRequestBody category) {
		Category temp = categoryRepo.findById(categoryID).get();
		temp.setCategoryName(category.getCategoryName());
		temp.setDescription(category.getDescription());
		temp.setImageUrl(category.getImageUrl());
		temp.setProducts(category.getProducts());

		return categoryRepo.save(temp);

	}
}