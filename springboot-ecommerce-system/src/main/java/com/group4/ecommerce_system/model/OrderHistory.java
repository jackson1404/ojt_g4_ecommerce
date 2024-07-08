package com.group4.ecommerce_system.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_histories")
public class OrderHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderHistoryId;
	
	private String orderStatus;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Order order;

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
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

	public OrderHistory(int orderHistoryId, String orderStatus, Order order) {
		this.orderHistoryId = orderHistoryId;
		this.orderStatus = orderStatus;
		this.order = order;
	}
	
	public OrderHistory() {
		
	}
	
}
