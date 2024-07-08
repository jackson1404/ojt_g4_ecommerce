package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.User;
import com.group4.ecommerce_system.repository.CustomerRepository;

@Service
public class AdminCustomerServiceImpl implements AdminCustomerService{

	@Autowired
	CustomerRepository customerRepo; 
	
	@Override
	public List<User> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public void deleteCustomerById(int id) {
		if(customerRepo.findById(id).isPresent())
		{
			customerRepo.deleteById(id);
		}
	}

	@Override
	public List<User> searchByCustomerName(String search) {
		return customerRepo.findByNameContainingIgnoreCase(search);
	}
}
