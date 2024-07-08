package com.group4.ecommerce_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.DeliveryCompany;

@Repository
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompany, Integer> {
	List<DeliveryCompany> findByCompanyNameContainingIgnoreCase(String search);

}
