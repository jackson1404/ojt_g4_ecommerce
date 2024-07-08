package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	@Column
	private int totalQuantity;

	@Column
	private int totalAmount;
	
	 @ManyToMany
	    @JoinTable(
	      name = "cart_product",
	      joinColumns = @JoinColumn(name = "cart_id"),
	      inverseJoinColumns = @JoinColumn(name = "product_id"))
	    private List<Product> cartProducts;

	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Order cartOrder;


	int getCartId() {
		return cartId;
	}


	void setCartId(int cartId) {
		this.cartId = cartId;
	}


	int getTotalQuantity() {
		return totalQuantity;
	}


	void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	int getTotalAmount() {
		return totalAmount;
	}


	void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}


	List<Product> getCartProducts() {
		return cartProducts;
	}


	void setCartProducts(List<Product> cartProducts) {
		this.cartProducts = cartProducts;
	}


	Order getCartOrder() {
		return cartOrder;
	}


	void setCartOrder(Order cartOrder) {
		this.cartOrder = cartOrder;
	}


	public Cart(int cartId, int totalQuantity, int totalAmount, List<Product> cartProducts, Order cartOrder) {
		this.cartId = cartId;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.cartProducts = cartProducts;
		this.cartOrder = cartOrder;
	}




}
