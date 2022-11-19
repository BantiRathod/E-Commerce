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
import com.ecommerce.Entities.Product;
import com.ecommerce.dto.ProductRequestBody;
import com.ecommerce.dto.ProductUpdateRequestBody;
import com.ecommerce.services.CategoryService;
import com.ecommerce.services.ProductService;

@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public ResponseEntity<?> getProducts() {
		try {
			List<Product> temp = productService.getAllProducts();
			if (temp.isEmpty()) {
				return new ResponseEntity<>("product not found", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(temp, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody ProductRequestBody productDto) {
		try {
			Category category = categoryService.findByCategoryId(productDto.getCategoryId());
			if (category == null) {
				return new ResponseEntity<>("category does not exist", HttpStatus.CONFLICT);
			}
			Product temp = productService.addProduct(category, productDto);
			return new ResponseEntity<>(temp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/updateproduct/{productID}")
	public ResponseEntity<?> updateProduct(@PathVariable("productID") Integer productID,
			@RequestBody ProductUpdateRequestBody productDto) {
		try {
			Category category = categoryService.findByCategoryId(productDto.getCategoryId());
			logger.info("category find");
			if (category == null) {
				logger.info("category not found");
				return new ResponseEntity<>("category is invalid", HttpStatus.CONFLICT);
			}

			Product temp = productService.updateProduct(productID, productDto);
			logger.info("update sucessfully category");
			return new ResponseEntity<>(temp, HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
