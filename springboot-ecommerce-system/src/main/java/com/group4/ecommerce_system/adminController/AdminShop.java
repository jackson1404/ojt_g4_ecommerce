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

import com.group4.ecommerce_system.model.Address;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.Shop;
import com.group4.ecommerce_system.model.ShopDto;
import com.group4.ecommerce_system.service.AdminService.AdminProductService;
import com.group4.ecommerce_system.service.AdminService.AdminShopService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/shops")
public class AdminShop {
	@Autowired
	private AdminShopService shopService;
	
	@Autowired
	private AdminProductService productService;
	
	@GetMapping({"","/"})
	public String getAdminShopsPage(Model model)
	{
		List<Shop> shop = shopService.getAllShops();
		model.addAttribute("shops",shop);
		return "admin/shop-folder/shops";
	}
	@GetMapping("/add-shop")
	public String getAdminShopAddPage(Model model)
	{
		ShopDto shopDto = new ShopDto();
		model.addAttribute("shopDto",shopDto);
		return "admin/shop-folder/shops-register";
	}
	@PostMapping("/add-shop")
	public String getShopData(@Valid @ModelAttribute("shopDto")ShopDto shopDto,
								 BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("shopDto",shopDto);
			return "admin/shop-folder/shops-register";
		}
		shopService.createShop(shopDto);
		return "redirect:/admin/shops";
	}
	@GetMapping("/edit")
	public String showEditShopPage(Model model,@RequestParam("id")int id)
	{
		ShopDto shopDto = new ShopDto();
		Shop shop = shopService.getShopById(id);
		shopDto.setShopBrandName(shop.getShopBrandName());
		shopDto.setShopEmail(shop.getShopEmail());
		
		model.addAttribute("shopDto",shopDto);
		return "admin/shop-folder/shops-register";
	}
	@PostMapping("/edit")
	public String editShop(@Valid @ModelAttribute("shopDto")ShopDto shopDto,
			                  BindingResult result,@RequestParam("id")int id,Model model)
	{
		if(result.hasErrors())
		{
			return "admin/shop-folder/shops-register";
		}
		shopService.editShop(shopDto, id);
		return "redirect:/admin/shops";
	}
	@GetMapping("/delete")
	public String deleteShop(@RequestParam("id")int id)
	{
		shopService.deleteShop(id);
		return "redirect:/admin/shops";
	}
	@GetMapping("/search")
	public String searchShopByName(@RequestParam("search")String search,Model model)
	{ 
		List<Shop> shops = shopService.searchShopsByName(search);
		model.addAttribute("shops",shops);
		return "admin/shop-folder/shops";
	}
	@GetMapping("/add-product-to-shop")
	public String showAddProductToShopPage(Model model)
	{
		List<Product> products = productService.getAllProducts();
		List<Shop> shops = shopService.getAllShops();
		ShopDto shopDto = new ShopDto();
		model.addAttribute("shops",shops);
		model.addAttribute("products",products);
		model.addAttribute("shopDto",shopDto);
		return "admin/shop-folder/shops-add-product";
	}
	@PostMapping("/add-product-to-shop")
	public String addProductToShop(@ModelAttribute("shopDto")ShopDto shopDto,
									   @RequestParam("shopId")int id)
	{
		shopService.addProductToShop(shopDto, id);
		return "redirect:/admin/shops";
	}
	@GetMapping("/add-address")
	public String showAddAddressToShopPage(Model model,@RequestParam("id")int id)
	{
		ShopDto shopDto = new ShopDto();
		Shop shop = shopService.getShopById(id);
		Address address = new Address();
		if(shop.getShopAddress()!=null)
		{
			address.setBuildingName(shop.getShopAddress().getBuildingName());
			address.setCity(shop.getShopAddress().getCity());
			address.setStreet(shop.getShopAddress().getStreet());
		}
		shopDto.setShopAddress(address);
		model.addAttribute("shopDto",shopDto);
		return "admin/shop-folder/shop-address-register";
	}
	@PostMapping("/add-address")
	public String addAddressToShop(@ModelAttribute("shopDto")ShopDto shopDto,@RequestParam("id")int id)
	{
		shopService.addAddressToShop(shopDto, id);
		return "redirect:/admin/shops";
	}
}
