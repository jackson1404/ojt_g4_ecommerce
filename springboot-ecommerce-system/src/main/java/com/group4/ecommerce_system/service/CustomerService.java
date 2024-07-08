package com.group4.ecommerce_system.service;

import java.util.List;

import com.group4.ecommerce_system.model.User;
import com.group4.ecommerce_system.model.UserDto;

public interface CustomerService {
	List<User> getAllCustomer();
	User getCustomerById(int CustomerId);
	User createCustomer(UserDto CustomerDto);
	void editCustomer(int CustomerId,UserDto CustomerDto );
	User addAddress(UserDto CustomerDto,int CustomerId);
	User updateCustomer(User Customer);
	User editAddress(UserDto CustomerDto, int CustomerId);
	 
}
