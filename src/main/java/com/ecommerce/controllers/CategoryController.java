package com.ecommerce.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Category;
import com.ecommerce.dto.CategoryRequestBody;
import com.ecommerce.dto.CategoryUpdatedRequestBody;
import com.ecommerce.services.CategoryService;

@RestController
public class CategoryController {

	Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/createcategory")
	public ResponseEntity<?> createCategory(@RequestBody CategoryRequestBody category) {

		try {
			// Check to see if the category exists by the category name then show category already exits
			List<Category> temp = categoryService.getCategoryByCategoryName(category.getCategoryName());
			if (!temp.isEmpty()) {
				logger.info("category already exists");

				return new ResponseEntity<>("category already exists", HttpStatus.CONFLICT);

			}
            // If the category doesn't exist then create category a response of created.
			Category cat = categoryService.createCategory(category);
			logger.info("category saved successfully");
			return new ResponseEntity<>(cat, HttpStatus.CREATED);

		} catch (Exception e) {
			// If the category doesn't exist then return a response of unsuccessful.
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

		}

	}

	@GetMapping("/getallcategory")
	public ResponseEntity<?> getAllCategories() {
		try {
			// Check to see if the category exists.
			List<Category> cat = categoryService.getAllCategories();
			if (cat.isEmpty()) {
				logger.info("category not found");

				return new ResponseEntity<>("Not found any categories", HttpStatus.NO_CONTENT);
			}
			// If the category exists then get all Categories successfully.
			logger.info("categories found successfully");
			return new ResponseEntity<>(cat, HttpStatus.OK);
		} catch (Exception e) {
			// If the category doesn't exist then return a response of unsuccessful.
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/updatecategory/{categoryID}")
	public ResponseEntity<?> updateCategory(@PathVariable("categoryID") Integer categoryID, @RequestBody CategoryUpdatedRequestBody category) {
		// Check to see if the category exists.
		try {
			Category temp = categoryService.findByCategoryId(categoryID);
			if (temp == null) {
				return new ResponseEntity<>("category does not exist", HttpStatus.CONFLICT);
			}

			// If the category exists then update it.
			Category cat = categoryService.updateCategory(categoryID, category);
			logger.info("updated the category");
			return new ResponseEntity<>(cat, HttpStatus.OK);

		} catch (Exception e) {
			logger.info("category does not exist");
			// If the category doesn't exist then return a response of unsuccessful.
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
