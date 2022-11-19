package com.ecommerce.dto;

import javax.validation.constraints.NotNull;

public class AddToCartDto {
	private @NotNull Integer productId;
    private @NotNull Integer quantity;
	public AddToCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToCartDto( @NotNull Integer productId, @NotNull Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "AddToCartDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
	

}
