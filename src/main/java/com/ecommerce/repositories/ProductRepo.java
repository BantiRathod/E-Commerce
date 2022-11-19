package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
