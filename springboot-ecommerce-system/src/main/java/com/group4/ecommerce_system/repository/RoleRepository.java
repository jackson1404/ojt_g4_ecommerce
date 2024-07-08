package com.group4.ecommerce_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r LEFT JOIN FETCH r.users WHERE r.name = :name")
	Optional<Role> findByName(String name);
	
}
