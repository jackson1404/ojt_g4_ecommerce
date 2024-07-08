package com.group4.ecommerce_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.ecommerce_system.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<User,Integer> {

//	User findbyEmailAndPassword(String email, String password);
	List<User> findByNameContainingIgnoreCase(String search);
	
	Optional<User> findByEmail(String email);


}
