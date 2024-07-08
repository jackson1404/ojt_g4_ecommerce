package com.group4.ecommerce_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
