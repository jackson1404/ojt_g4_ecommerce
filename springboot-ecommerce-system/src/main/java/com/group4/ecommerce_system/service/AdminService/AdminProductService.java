package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.ProductDto;

public interface AdminProductService {
	List<Product> getAllProducts();
	Product getProductById(int id);
	void createProduct(ProductDto productDto);
	void editProduct(ProductDto productDto,int id);
	void deleteProduct(int id);
	List<Product> searchProductsByName(String productName);
}
    