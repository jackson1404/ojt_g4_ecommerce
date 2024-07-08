package com.group4.ecommerce_system.service.serviceImpl;

import com.group4.ecommerce_system.model.Order;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.repository.OrderRepository;
import com.group4.ecommerce_system.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addToCart(Product product) {
        Optional<Order> existingOrderOpt = orderRepository.findFirstByProducts_ProductIdAndStatus(product.getProductId(), "cart");
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.addProduct(product, 1); // Assuming quantity increment by 1
            orderRepository.save(existingOrder);
        } else {
            Order newOrder = new Order();
            newOrder.setStatus("cart");
            newOrder.addProduct(product, 1); // Assuming quantity increment by 1
            orderRepository.save(newOrder);
        }
    }

    @Override
    public void removeFromCart(Product product) {
        Optional<Order> existingOrderOpt = orderRepository.findFirstByProducts_ProductIdAndStatus(product.getProductId(), "cart");
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.removeProduct(product);
            orderRepository.save(existingOrder);
        }
    }

    @Override
    public List<Order> getCartItems() {
        return orderRepository.findByStatus("cart");
    }


    @Override
    public void updateCartItemQuantity(Product product, int quantity) {
        Optional<Order> existingOrderOpt = orderRepository.findFirstByProducts_ProductIdAndStatus(product.getProductId(), "cart");
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.updateProductQuantity(product, quantity);
            orderRepository.save(existingOrder);
        }
    }

    @Override
    public void clearCart() {
        List<Order> cartOrders = orderRepository.findByStatus("cart");
        orderRepository.deleteAll(cartOrders);
    }
}
