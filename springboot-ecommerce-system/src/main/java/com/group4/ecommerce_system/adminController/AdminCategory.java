package com.group4.ecommerce_system.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group4.ecommerce_system.model.Category;
import com.group4.ecommerce_system.model.CategoryDto;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.service.AdminService.AdminCategoryService;
import com.group4.ecommerce_system.service.AdminService.AdminProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategory {
	
	@Autowired
	private AdminCategoryService categoryService;
	
	@Autowired
	private AdminProductService productService;
	
	@GetMapping({"","/"})
	public String getAdminCategoriesPage(Model model)
	{
		List<Category> category = categoryService.getAllCategories();
		model.addAttribute("categories",category);
		return "admin/category-folder/categories";
	}
	@GetMapping("/add-category")
	public String getAdminCategoryAddPage(Model model)
	{
		CategoryDto categoryDto = new CategoryDto();
		model.addAttribute("categoryDto",categoryDto);
		return "admin/category-folder/categories-register";
	}
	@PostMapping("/add-category")
	public String getCategoryData(@Valid @ModelAttribute("categoryDto")CategoryDto categoryDto,
								 BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("categoryDto",categoryDto);
			return "admin/category-folder/categories-register";
		}
		categoryService.createCategory(categoryDto);
		return "redirect:/admin/categories";
	}
	@GetMapping("/edit")
	public String showEditCategoryPage(Model model,@RequestParam("id")int id)
	{
		CategoryDto categoryDto = new CategoryDto();
		Category category = categoryService.getCategoryById(id);
		categoryDto.setCategoryName(category.getCategoryName());
		model.addAttribute("categoryDto",categoryDto);
		return "admin/category-folder/categories-register";
	}
	@PostMapping("/edit")
	public String editCategory(@Valid @ModelAttribute("categoryDto")CategoryDto categoryDto,
			                  BindingResult result,@RequestParam("id")int id)
	{
		if(result.hasErrors())
		{
			return "admin/category-folder/categories-register";
		}
		categoryService.editCategory(categoryDto,id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("id")int id)
	{
		categoryService.deleteCategory(id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/search")
	public String searchProductByName(@RequestParam("search")String search,Model model)
	{ 
		List<Category> categories = categoryService.searchCategoryByName(search);
		model.addAttribute("categories",categories);
		return "admin/category-folder/categories";
	}
	@GetMapping("/add-product-to-category")
	public String showAddProductToCategoryPage(Model model)
	{
		List<Product> products = productService.getAllProducts();
		List<Category> categories = categoryService.getAllCategories();
		CategoryDto categoryDto = new CategoryDto();
		model.addAttribute("categories",categories);
		model.addAttribute("products",products);
		model.addAttribute("categoryDto",categoryDto);
		return "admin/category-folder/categories-add-product";
	}
	@PostMapping("/add-product-to-category")
	public String addProductToCategory(@ModelAttribute("categoryDto")CategoryDto categoryDto,
									   @RequestParam("categoryId")int id)
	{
		categoryService.addProductToCategory(categoryDto, id);
		return "redirect:/admin/categories";
	}
}
