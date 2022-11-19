package com.ecommerce.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Order;
import com.ecommerce.Entities.OrderItem;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.CartDto;
import com.ecommerce.dto.CartItemDto;
import com.ecommerce.repositories.OrderItemRepo;
import com.ecommerce.repositories.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderItemRepo orderItemRepo;

	public  Order placeOrder(Users user) {
		 // first let get cart items for the user
		CartDto cartDto =  cartService.listCartItems(user);
		List<CartItemDto> cartItemDtoList = cartDto.getCartItems();
		
		 // create the order and save it
		 Order newOrder = new Order();
	        newOrder.setCreatedDate(new Date());
	        newOrder.setUser(user);
	        newOrder.setTotalPrice(cartDto.getTotalCost());
	       Order or = orderRepo.save(newOrder);
	        
	        for (CartItemDto cartItemDto : cartItemDtoList) {
	            // create orderItem and save each one
	            OrderItem orderItem = new OrderItem();
	            orderItem.setCreatedDate(new Date());
	            orderItem.setPrice(cartItemDto.getProduct().getPrice());
	            orderItem.setProduct(cartItemDto.getProduct());
	            orderItem.setQuantity(cartItemDto.getQuantity());
	            orderItem.setOrder(newOrder);
	            // add to order item list
	            orderItemRepo.save(orderItem);
	        }
	        
	        cartService.deleteUserCartItems(user);
		return or;
	}

	public List<Order> getAllOrder() {
		
		return orderRepo.findAll();
	}

	

	public Order getOrder(Integer id) {
		return orderRepo.findById(id).get();
	}

}
