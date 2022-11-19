package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entities.Cart;
import com.ecommerce.Entities.Users;
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{

	List<Cart> findAllByUserOrderByCreatedDateDesc(Users user);

	List<Cart> findAllByuserId(int id);

	List<Cart> deleteByUser(Users user);

	

}
