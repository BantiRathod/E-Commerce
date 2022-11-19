package com.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Order;
import com.ecommerce.Entities.Users;
import com.ecommerce.services.CartService;
import com.ecommerce.services.OrderService;
import com.ecommerce.services.UsersService;

@RestController
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UsersService userService;
	
	@PostMapping("/order/{userId}")
	public ResponseEntity<?> placeOrder(@Valid @PathVariable int userId){
		try {
			Users user = userService.getUserById(userId);
			Order or = orderService.placeOrder(user);
			return new ResponseEntity<>(or,HttpStatus.CREATED);
			
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	 
	 @GetMapping("/orders")
		public ResponseEntity<?> getAllOrder() {
			List<Order> temp = null;
			try {
				temp = this.orderService.getAllOrder();
				if (temp.size() == 0)
					throw new Exception("not found any Order");
				else
					logger.info("Data found");

				return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

			} catch (Exception e) {
				logger.info(e.getMessage());

				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

			}
	 }

	    // get order items for an order
	    @GetMapping("order/{orderId}")
	    public ResponseEntity<?> getOrderById(@PathVariable Integer orderId){
	        try {
	            Order order = orderService.getOrder(orderId);
	            return new ResponseEntity<>(order,HttpStatus.OK);
	        }
	        catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        }

	    }
	
	

}
