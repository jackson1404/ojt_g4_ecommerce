package com.group4.ecommerce_system.service;

import java.util.List;

import com.group4.ecommerce_system.model.Order;

public interface CustomerOrderService {

	void addProductToOrder(int productId, int quantity);

	List<Order> getCartOrders();
}
