package com.group4.ecommerce_system.repository;

import com.group4.ecommerce_system.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Query to find orders by product ID and status
    List<Order> findByProducts_ProductIdAndStatus(int productId, String status);

    // Query to find orders by status
    List<Order> findByStatus(String status);

    // Optional query to find an order by product ID and status
    Optional<Order> findFirstByProducts_ProductIdAndStatus(int productId, String status);
}
