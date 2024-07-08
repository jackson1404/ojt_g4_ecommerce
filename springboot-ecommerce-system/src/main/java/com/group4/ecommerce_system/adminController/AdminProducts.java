package com.group4.ecommerce_system.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.group4.ecommerce_system.model.Category;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.ProductDto;
import com.group4.ecommerce_system.model.Shop;
import com.group4.ecommerce_system.service.AdminService.AdminCategoryService;
import com.group4.ecommerce_system.service.AdminService.AdminProductService;
import com.group4.ecommerce_system.service.AdminService.AdminShopService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/products")
public class AdminProducts {
	
	@Autowired
	AdminProductService productService;
	
	@Autowired
	AdminShopService shopService;
	
	@Autowired
	AdminCategoryService categoryService;
	
	@GetMapping({"","/"})
	public String getAdminProductsPage(Model model)
	{
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products",products);
		return "admin/product-folder/products";
	}
	@GetMapping("/add-products")
	public String getAdminProductAddPage(Model model)
	{
		ProductDto productDto = new ProductDto();
		List<Category> category = categoryService.getAllCategories();
		List<Shop> shop = shopService.getAllShops();
		model.addAttribute("shops",shop);
		model.addAttribute("categories",category);
		model.addAttribute("productDto",productDto);
		return "admin/product-folder/products-register";
	}
	@PostMapping("/add-products")
	public String getProductData(@Valid @ModelAttribute("productDto")ProductDto productDto,
								 BindingResult result, @RequestParam("productImage")MultipartFile productImage,
								 @RequestParam("categoryId")int categoryId,@RequestParam("shopId")int shopId,
								 Model model)
	{
		if(productDto.getProductBrand().isEmpty())
		{
			result.addError(new FieldError("productDto","productImage","The image is required."));	
		}
		if(result.hasErrors())
		{
			model.addAttribute("productDto",productDto);
			return "admin/product-folder/products-register";
		}
		if(categoryId!=0)
		{
			productDto.setCategory(categoryService.getCategoryById(categoryId));
		}
		if(shopId!=0)
		{
			productDto.setShop(shopService.getShopById(shopId));
		}
		productDto.setProductImage(productImage);
		productService.createProduct(productDto);
		return "redirect:/admin/products";
	}
	@GetMapping("/edit")
	public String showEditProductPage(Model model,@RequestParam("id")int id)
	{
		ProductDto productDto = new ProductDto();
		Product product = productService.getProductById(id);
		productDto.setProductName(product.getProductName());
		productDto.setProductBrand(product.getProductBrand());
		productDto.setProductPrice(product.getProductPrice());
		productDto.setQuantity(product.getQuantity());
		productDto.setDescription(product.getDescription());
		model.addAttribute("productDto",productDto);
		model.addAttribute("productImage",product.getProductImageFileName());
		return "admin/product-folder/products-register";
	}
	@PostMapping("/edit")
	public String editProduct(@Valid @ModelAttribute("productDto")ProductDto productDto,
			                  BindingResult result,@RequestParam("id")int id,
			                  @RequestParam("productImage")MultipartFile productImage,Model model)
	{
		Product product = productService.getProductById(id);
		if(result.hasErrors())
		{
			model.addAttribute("productImage",product.getProductImageFileName());
			return "admin/product-folder/products-register";
		}
		if (!productImage.isEmpty()) {
			productDto.setProductImage(productImage);
		} else {
			productDto.setProductImage(null);
		}
		productService.editProduct(productDto, id);
		return "redirect:/admin/products";
	}
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id")int id)
	{
		productService.deleteProduct(id);
		return "redirect:/admin/products";
	}
	@GetMapping("/search")
	public String searchProductByName(@RequestParam("search")String search,Model model)
	{ 
		List<Product> products = productService.searchProductsByName(search);
		model.addAttribute("products",products);
		return "admin/product-folder/products";
	}
} 	
