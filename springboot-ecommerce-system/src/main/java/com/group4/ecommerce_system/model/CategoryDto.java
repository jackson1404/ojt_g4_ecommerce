package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDto {
	
	@NotEmpty(message = "Category name is required!")
	private String categoryName;
	
	private List<Product> productCategories;

	public CategoryDto() {
		
	}
	
	public CategoryDto(@NotEmpty(message = "Category name is required!") String categoryName,
			List<Product> productCategories) {
		this.categoryName = categoryName;
		this.productCategories = productCategories;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<Product> productCategories) {
		this.productCategories = productCategories;
	}
	
	
}
