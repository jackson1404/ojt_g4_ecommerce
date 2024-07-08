package com.group4.ecommerce_system.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class OrderDto {
	@NotEmpty(message = "Date is required!")
	private Date orderDate;
	@NotEmpty(message = "Price is required!")
	private double totalPrice;
	@NotEmpty(message = "Order Quantity is required!")
	private int orderQuantity;

	private User customerOrder;
	private DeliveryInformation deliveryInformation;
	private OrderHistory orderHistory;
	private List<Product> products;
	private Payment payment;
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public OrderDto() {

	}

	

	public OrderDto(@NotEmpty(message = "Date is required!") Date orderDate,
			@NotEmpty(message = "Price is required!") double totalPrice,
			@NotEmpty(message = "Order Quantity is required!") int orderQuantity, User customerOrder,
			DeliveryInformation deliveryInformation, OrderHistory orderHistory, List<Product> products,
			Payment payment) {
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderQuantity = orderQuantity;
		this.customerOrder = customerOrder;
		this.deliveryInformation = deliveryInformation;
		this.orderHistory = orderHistory;
		this.products = products;
		this.payment = payment;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public User getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(User customerOrder) {
		this.customerOrder = customerOrder;
	}

	public DeliveryInformation getDeliveryInformation() {
		return deliveryInformation;
	}

	public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
		this.deliveryInformation = deliveryInformation;
	}

	public OrderHistory getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(OrderHistory orderHistory) {
		this.orderHistory = orderHistory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
