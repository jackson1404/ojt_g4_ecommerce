//package com.group4.ecommerce_system.service.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.group4.ecommerce_system.model.User;
//import com.group4.ecommerce_system.repository.CustomerRepository;
//import com.group4.ecommerce_system.service.CustomerLoginService;
//
//@Service
//public class CustomerLoginServiceImpl implements CustomerLoginService {
//
//	@Autowired
//	private CustomerRepository customerRepository;
//
//	@Override
//	public User authenticate(String email, String password) {
//		User customer = customerRepository.findbyEmailAndPassword(email, password);
//		return customer;
//	}
//}