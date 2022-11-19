package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {

}
