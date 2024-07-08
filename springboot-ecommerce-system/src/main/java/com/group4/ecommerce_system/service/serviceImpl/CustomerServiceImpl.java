package com.group4.ecommerce_system.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Address;
import com.group4.ecommerce_system.model.User;
import com.group4.ecommerce_system.model.UserDto;
import com.group4.ecommerce_system.repository.CustomerRepository;
import com.group4.ecommerce_system.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public User createCustomer(UserDto customerDto) {
        User customer = new User();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return repo.save(customer); // Return the saved customer
    }
    @Override
	public User getCustomerById(int customerId) {
		// TODO Auto-generated method stub
        return repo.findById(customerId).orElse(null);
	}


    @Override
    public void editCustomer(int customerId, UserDto customerDto) {
       Optional<User> optionalCustomer=repo.findById(customerId);
       if(optionalCustomer.isPresent()) {
    	   User existingCustomer=optionalCustomer.get();
    	   existingCustomer.setName(customerDto.getName());
    	   existingCustomer.setEmail(customerDto.getEmail());
    	   existingCustomer.setPh_no(customerDto.getPh_no());
    	   repo.save(existingCustomer);
       }     
    }

    @Override
    public List<User> getAllCustomer() {
        return repo.findAll();
    }

	

	@Override
	public User addAddress(UserDto customerDto, int customerId) {
		User customer=getCustomerById(customerId);
		Address address=new Address();
		address.setBuildingName(customerDto.getUserAddress().getBuildingName());
		address.setCity(customerDto.getUserAddress().getCity());
		address.setStreet(customerDto.getUserAddress().getStreet());
		customer.setUserAddress(address);
		return repo.save(customer);
	}
	@Override
	public User editAddress(UserDto customerDto, int customerId) {
	    User customer = getCustomerById(customerId);
	    
	    // Assuming customerDto contains updated address details
	    if (customerDto.getUserAddress() != null) {
	        Address address = customer.getUserAddress();
	        address.setBuildingName(customerDto.getUserAddress().getBuildingName());
	        address.setCity(customerDto.getUserAddress().getCity());
	        address.setStreet(customerDto.getUserAddress().getStreet());
	        customer.setUserAddress(address);
	    }
	    
	    return repo.save(customer);
	}
	
	@Override
	public User updateCustomer(User customer) {
        return repo.save(customer);
	}

	

	
}
