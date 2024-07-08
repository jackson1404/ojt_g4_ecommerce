package com.group4.ecommerce_system.service.AdminService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.group4.ecommerce_system.configuration.FileStorageConfig;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.ProductDto;
import com.group4.ecommerce_system.repository.ProductRepository;

@Service
public class AdminProoductServiceImpl implements AdminProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	FileStorageConfig fileStorageConfig;

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public void createProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setProductBrand(productDto.getProductBrand());
		product.setDescription(productDto.getDescription());
		product.setProductPrice(productDto.getProductPrice());
		product.setQuantity(productDto.getQuantity());
		product.setProductImageFileName(productDto.getProductImage().getOriginalFilename());
		String imageFileName = productDto.getProductImage().getOriginalFilename();
		product.setProductImageFileName(imageFileName);
		if(!productDto.getProductImage().isEmpty())
		{
			try
			{
				fileStorageConfig.saveFile(productDto.getProductImage(), imageFileName);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		productRepo.save(product);
	}

	@Override
	public void editProduct(ProductDto productDto, int id) {
		Product product = getProductById(id);
		product.setProductName(productDto.getProductName());
		product.setProductBrand(productDto.getProductBrand());
		product.setDescription(productDto.getDescription());
		product.setProductPrice(productDto.getProductPrice());
		product.setQuantity(productDto.getQuantity());
		MultipartFile multipartFile = productDto.getProductImage();
	    if (multipartFile != null && !multipartFile.isEmpty() && multipartFile.getOriginalFilename() != null) 
	    {
	    	String imageFileName = productDto.getProductImage().getOriginalFilename();
    		product.setProductImageFileName(imageFileName);
    		try
    		{
    			fileStorageConfig.saveFile(productDto.getProductImage(), imageFileName);
    		}
    		catch(IOException e)
    		{
    			e.printStackTrace();
    		}
        }
        productRepo.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productRepo.findById(id).orElse(null);
		try
		{
			fileStorageConfig.deleteFile(product.getProductImageFileName());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if(productRepo.findById(id).isPresent())
		{
			productRepo.deleteById(id);
		}
	}
	
	public List<Product> searchProductsByName(String productName) {
		return productRepo.findByProductNameContainingIgnoreCase(productName);
	}
}
