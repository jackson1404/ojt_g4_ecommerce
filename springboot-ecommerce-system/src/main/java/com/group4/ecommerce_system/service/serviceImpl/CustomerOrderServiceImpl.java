package com.group4.ecommerce_system.service.serviceImpl;

import com.group4.ecommerce_system.model.Order;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.repository.OrderRepository;
import com.group4.ecommerce_system.repository.ProductRepository;
import com.group4.ecommerce_system.service.CustomerOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProductToOrder(int productId, int quantity) {
        // Check if product exists
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        // Check if an order with this product ID already exists
        Order order = orderRepository.findFirstByProducts_ProductIdAndStatus(productId, "cart")
                .orElseGet(() -> {
                    Order newOrder = new Order();
                    newOrder.setStatus("cart");
                    return newOrder;
                });

        // Update or add product to the order
        order.addProduct(product, quantity);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getCartOrders() {
        return orderRepository.findByStatus("cart");
    }
}
