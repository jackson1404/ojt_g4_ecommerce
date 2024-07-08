package com.group4.ecommerce_system.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDto {
	
	@NotEmpty(message = "Name is required!")
	private String productName;
	
	@NotEmpty(message = "Brand is required!")
	private String productBrand;
	
	@Min(value = 0,message = "Price must not be below 0!")
	private double productPrice;
	
	@Size(max = 100, message = "Description must be less than 100 characters!")
	@Size(min = 0, message = "Description field must not be empty!")
	@NotEmpty(message = "Description feild is required!")
	private String description;
	
	@Min(value = 0,message = "Price must not be below 0!")
	private int quantity;

	private MultipartFile productImage;

	private List<Order> productOrders;
	private Category category;
	private Shop shop;

	public ProductDto(){
		
	}
	
	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ProductDto(@NotEmpty(message = "Name is required!") String productName,
			@NotEmpty(message = "Brand is required!") String productBrand,
			@Min(value = 0, message = "Price must not be below 0!") double productPrice,
			@Size(max = 100, message = "Description must be less than 100 characters!") @Size(min = 0, message = "Description field must not be empty!") @NotEmpty(message = "Description feild is required!") String description,
			@Min(value = 0, message = "Price must not be below 0!") int quantity, MultipartFile productImage,
			List<Order> productOrders, Category category, Shop shop) {
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.description = description;
		this.quantity = quantity;
		this.productImage = productImage;
		this.productOrders = productOrders;
		this.category = category;
		this.shop = shop;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public List<Order> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<Order> productOrders) {
		this.productOrders = productOrders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
