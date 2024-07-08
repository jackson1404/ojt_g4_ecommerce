package com.group4.ecommerce_system.model;

import jakarta.validation.constraints.NotEmpty;

public class OrderHistoryDto {
	@NotEmpty(message = "Order stuatus is required!")
	private String orderStatus;
	
	private Order order;

	public OrderHistoryDto() {
		
	}
	
	public OrderHistoryDto(@NotEmpty(message = "Order stuatus is required!") String orderStatus, Order order) {
		this.orderStatus = orderStatus;
		this.order = order;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
