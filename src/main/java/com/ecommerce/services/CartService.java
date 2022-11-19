package com.ecommerce.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entities.Cart;
import com.ecommerce.Entities.Product;
import com.ecommerce.Entities.Users;
import com.ecommerce.dto.AddToCartDto;
import com.ecommerce.dto.CartDto;
import com.ecommerce.dto.CartItemDto;
import com.ecommerce.repositories.CartRepo;

@Service
@Transactional
public class CartService {
	
	@Autowired
	CartRepo cartRepo;

	public Cart addToCart(@Valid AddToCartDto addToCartDto, Product product, Users user) {
		  Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
		
	       return  cartRepo.save(cart);
		 
		
	}

	public CartDto listCartItems(Users user) {
		  List<Cart> cartList = cartRepo.findAllByuserId(user.getId());
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        return new CartDto(cartItems,totalCost);
	}
	
	public static CartItemDto getDtoFromCart(Cart cart) {
        return new CartItemDto(cart);
    }

	public Cart updateCartItem(@Valid AddToCartDto cartDto, Users user, Product product, @Valid int cartId) {
		Cart cart = cartRepo.findById(cartId).get();
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        return cartRepo.save(cart);
		
	}
	
	 public void deleteCartItem(int id,int userId) throws Exception  {
	        if (!cartRepo.existsById(id))
	            throw new Exception("Cart id is invalid : " + id);
	        cartRepo.deleteById(id);

	    }
	 
	

	public void deleteUserCartItems(Users user) {
		// TODO Auto-generated method stub
		cartRepo.deleteByUser(user);
		
	}

	

}
