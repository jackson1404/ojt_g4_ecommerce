package com.group4.ecommerce_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

	List<Category> findByCategoryNameContainingIgnoreCase(String search);

}
