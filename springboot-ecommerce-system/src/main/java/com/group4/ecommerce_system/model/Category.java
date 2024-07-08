package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	private String categoryName;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> productCategories;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public Category(int categoryId, String categoryName, List<Product> productCategories) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productCategories = productCategories;
	}
	
	public Category() {
		
	}
	
	
}
