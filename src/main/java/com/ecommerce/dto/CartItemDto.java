package com.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.ecommerce.Entities.Cart;
import com.ecommerce.Entities.Product;

public class CartItemDto {
	private @NotNull Integer quantity;
	private @NotNull Product product;

	public CartItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemDto(Cart cart) {
		super();
		this.quantity = (cart.getQuantity());
		this.product = (cart.getProduct());
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItemDto [quantity=" + quantity + ", product=" + product + "]";
	}

}
