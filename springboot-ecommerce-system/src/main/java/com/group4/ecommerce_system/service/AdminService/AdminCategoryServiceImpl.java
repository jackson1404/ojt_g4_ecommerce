package com.group4.ecommerce_system.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Category;
import com.group4.ecommerce_system.model.CategoryDto;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.repository.CategoryRepository;
import com.group4.ecommerce_system.repository.ProductRepository;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public void createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryName(categoryDto.getCategoryName());
		categoryRepo.save(category);
	}

	@Override
	public void editCategory(CategoryDto categoryDto, int id) {
		Category category = getCategoryById(id);
		category.setCategoryName(categoryDto.getCategoryName());
		categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		if(categoryRepo.findById(id).isPresent())
		{
			Category category = categoryRepo.findById(id).orElse(null);
			List<Product> products = productRepo.findByCategory(category);
			for(Product product : products)
			{
				product.setCategory(null);
			}
			categoryRepo.deleteById(id);
		}
	}

	@Override
	public List<Category> searchCategoryByName(String search) {
		return categoryRepo.findByCategoryNameContainingIgnoreCase(search);
	}

	@Override
	public void addProductToCategory(CategoryDto categoryDto, int id) {
		Category category = categoryRepo.findById(id).orElse(null);
		if (category == null) 
		{
	        throw new RuntimeException("Category not found");
	    }
		List<Product> products = productRepo.findAllById(categoryDto.getProductCategories().stream().map(Product::getProductId).collect(Collectors.toList()));
		for(Product product : products)
		{
			product.setCategory(category);
			productRepo.save(product);
		}
		category.setProductCategories(products);
		categoryRepo.save(category);
	}
}
