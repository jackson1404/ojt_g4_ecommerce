package com.group4.ecommerce_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer>{
	List<Shop> findByShopBrandNameContainingIgnoreCase(String search);
}
