package com.ecommerce.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Category;
import com.ecommerce.Entities.Product;
import com.ecommerce.dto.ProductRequestBody;
import com.ecommerce.dto.ProductUpdateRequestBody;
import com.ecommerce.repositories.CategoryRepo;
import com.ecommerce.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;

	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}

	public Product addProduct(Category category, ProductRequestBody productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setImageURL(productDto.getImageURL());
		product.setCreatedAt(new Date());
		product.setUpdatedAt(new Date());
		product.setCategory(category);
		
		return productRepo.save(product);
		
	}

	public Product updateProduct(Integer productID, ProductUpdateRequestBody productDto) throws Exception {
		Optional<Product> temp = productRepo.findById(productID);
		if(!temp.isPresent()) {
			throw new Exception ("product not present");
		}
		
		Product pro = temp.get();
		pro.setDescription(productDto.getDescription());
		pro.setName(productDto.getName());
		pro.setImageURL(productDto.getImageURL());
		pro.setPrice(productDto.getPrice());
		pro.setCategory(categoryRepo.findById(productDto.getCategoryId()).get());
		pro.setUpdatedAt(new Date());
		
		
		return pro;
	}

	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		
		
		return productRepo.findById(productId).get();
	}

}
