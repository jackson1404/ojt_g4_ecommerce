package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import com.group4.ecommerce_system.model.Category;
import com.group4.ecommerce_system.model.CategoryDto;

public interface AdminCategoryService {
	List<Category> getAllCategories();
	Category getCategoryById(int id);
	void createCategory(CategoryDto categoryDto);
	void editCategory(CategoryDto categoryDto,int id);
	void deleteCategory(int id);
	List<Category>searchCategoryByName(String search);
	void addProductToCategory(CategoryDto categoryDto,int id);
}
