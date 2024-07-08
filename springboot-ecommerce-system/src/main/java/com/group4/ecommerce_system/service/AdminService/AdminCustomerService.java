package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import com.group4.ecommerce_system.model.User;

public interface AdminCustomerService {
	List<User> getAllCustomers();
	void deleteCustomerById(int id);
	List<User> searchByCustomerName(String search);
}
