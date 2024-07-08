package com.group4.ecommerce_system.service;

import com.group4.ecommerce_system.model.Order;
import com.group4.ecommerce_system.model.Product;

import java.util.List;

public interface CartService {

    // Add product to cart
    void addToCart(Product product);

    // Remove product from cart
    void removeFromCart(Product product);

    // Get all products in the cart
    List<Order> getCartItems();

    // Update cart item quantity
    void updateCartItemQuantity(Product product, int quantity);

    // Clear the cart
    void clearCart();

}
