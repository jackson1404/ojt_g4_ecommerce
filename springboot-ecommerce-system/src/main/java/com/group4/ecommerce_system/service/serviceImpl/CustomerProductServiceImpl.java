package com.group4.ecommerce_system.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.repository.ProductRepository;
import com.group4.ecommerce_system.service.CustomerProductService;

@Service
public class CustomerProductServiceImpl implements CustomerProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

//	@Override
//	public Product findById(Long id) {
//		return productRepository.findById(id);
//	}

}
