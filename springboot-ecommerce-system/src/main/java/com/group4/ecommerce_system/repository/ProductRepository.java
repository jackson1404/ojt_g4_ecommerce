package com.group4.ecommerce_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.Category;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.Shop;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	List<Product> findByProductNameContainingIgnoreCase(String productName);
	List<Product> findByCategory(Category category);
	List<Product> findByShop(Shop shop);
}
