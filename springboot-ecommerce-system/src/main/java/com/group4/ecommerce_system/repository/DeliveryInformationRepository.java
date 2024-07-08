package com.group4.ecommerce_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.DeliveryInformation;

@Repository
public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformation,Integer>{

}
