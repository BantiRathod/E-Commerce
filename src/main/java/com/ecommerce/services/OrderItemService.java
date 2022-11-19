package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repositories.OrderItemRepo;

@Service
public class OrderItemService {
	@Autowired
	OrderItemRepo orderItemRepo;

}
