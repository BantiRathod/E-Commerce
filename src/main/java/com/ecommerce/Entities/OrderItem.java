package com.ecommerce.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "orderitems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull 
	private  int quantity;
	@NotNull
	private double price;
	
	private Date createdDate;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public OrderItem(int id, @NotNull int quantity, @NotNull double price, Date createdDate, Order order,
			Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.createdDate = createdDate;
		this.order = order;
		this.product = product;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", createdDate=" + createdDate
				+ ", order=" + order + ", product=" + product + "]";
	}



	

	
}
