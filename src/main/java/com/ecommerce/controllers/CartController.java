package com.ecommerce.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Entities.Cart;
import com.ecommerce.Entities.Product;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddToCartDto;
import com.ecommerce.dto.CartDto;
import com.ecommerce.services.CartService;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.UsersService;

@RestController
public class CartController {
	Logger logger = LoggerFactory.getLogger(CartController.class);
	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;
	@Autowired
	UsersService userService;

	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addToCart(@Valid @PathVariable int userId, @Valid @RequestBody AddToCartDto addToCartDto) {
		try {
			Product product = productService.getProductById(addToCartDto.getProductId());
			Users user = userService.getUserById(userId);
			Cart res = cartService.addToCart(addToCartDto, product, user);
			return new ResponseEntity<>(res, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getcartitem/{userId}")
	public ResponseEntity<?> getCartItems(@Valid @PathVariable int userId) {
		try {
			Users user = userService.getUserById(userId);
			CartDto cartDto = cartService.listCartItems(user);
			return new ResponseEntity<>(cartDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update/{cartId}/{userId}")
	public ResponseEntity<?> updateCartItem(@Valid @PathVariable int cartId,@PathVariable int userId,
			@RequestBody @Valid AddToCartDto cartDto) {
		try {
			Users user = userService.getUserById(userId);
			Product product = productService.getProductById(cartDto.getProductId());
			Cart cart = cartService.updateCartItem(cartDto, user, product, cartId);
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	 @DeleteMapping("/delete/{cartItemId}/{userId}")
	    public ResponseEntity<?> deleteCartItem(@PathVariable("cartItemId") int itemID,@PathVariable int userId) {
	      try {  
	        cartService.deleteCartItem(itemID, userId);
	        return new ResponseEntity<>("item deleted in cart successfully" , HttpStatus.OK);
	      }catch(Exception e) {
	    	  return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	      }
	    }


}
