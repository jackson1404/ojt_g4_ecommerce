package com.group4.ecommerce_system.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {
	
	@GetMapping({"", "/","/dashboard"})
	public String adminHomePage()
	{
		return "admin/dashboard";
	}
	@GetMapping("/blank-page")
	public String blankPage()
	{
		return "admin/Ui-test";
	}
}
