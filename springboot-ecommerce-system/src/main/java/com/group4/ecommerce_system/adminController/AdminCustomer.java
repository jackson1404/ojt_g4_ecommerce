package com.group4.ecommerce_system.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.group4.ecommerce_system.model.User;
import com.group4.ecommerce_system.service.AdminService.AdminCustomerService;

@Controller
@RequestMapping("/admin/customers")
public class AdminCustomer {
	
	@Autowired
	AdminCustomerService customerService;
	
	@GetMapping({"","/"})
	public String getAdminCustomersPage(Model model)
	{
		List<User> customer = customerService.getAllCustomers();
		model.addAttribute("customers",customer);
		return "admin/customer-folder/customers";
	}
	
	@GetMapping("/search")
	public String searchCustomerByName(@RequestParam("search")String search,Model model)
	{
		List<User> customer = customerService.searchByCustomerName(search);
		model.addAttribute("customers",customer);
		return "admin/customer-folder/customers";
	}
}
