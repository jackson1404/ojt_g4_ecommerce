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
import com.group4.ecommerce_system.model.DeliveryCompany;
import com.group4.ecommerce_system.model.DeliveryCompanyDto;
import com.group4.ecommerce_system.service.AdminService.AdminDeliveryCompanyService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/delivery-companies")
public class AdminDeliveryCompany {
	
	@Autowired
	AdminDeliveryCompanyService deliveryCompanyService;
	
	@GetMapping({"","/"})
	public String getAdminDelieryCompanyPage(Model model)
	{
		List<DeliveryCompany> deliverycompany = deliveryCompanyService.getAllDeliveryCompanies();
		model.addAttribute("deliveryCompanies",deliverycompany);
		return "admin/delivery-company-folder/delivery-companies";
	}
	@GetMapping("/add-delivery-company")
	public String getAdminDelieryCompanyAddPage(Model model)
	{
		DeliveryCompanyDto deliveryCompanyDto = new DeliveryCompanyDto();
		model.addAttribute("deliveryCompanyDto",deliveryCompanyDto);
		return "admin/delivery-company-folder/delivery-company-register";
	}
	@PostMapping("/add-delivery-company")
	public String getDelieryCompanyData(@Valid @ModelAttribute("deliveryCompanyDto")DeliveryCompanyDto deliveryCompanyDto,
								 BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("deliveryCompanyDto",deliveryCompanyDto);
			return "admin/delivery-company-folder/delivery-company-register";
		}
		deliveryCompanyService.createDeliveryCompany(deliveryCompanyDto);
		return "redirect:/admin/delivery-companies";
	}
	@GetMapping("/edit")
	public String showEditDelieryCompanyPage(Model model,@RequestParam("id")int id)
	{
		DeliveryCompanyDto deliveryCompanyDto = new DeliveryCompanyDto();
		DeliveryCompany deliveryCompany = deliveryCompanyService.getDeliveryCompanyById(id);
		deliveryCompanyDto.setCompanyName(deliveryCompany.getCompanyName());
		deliveryCompanyDto.setDeliveryCompanyEmail(deliveryCompany.getDeliveryCompanyEmail());
		deliveryCompanyDto.setDeliveryScope(deliveryCompany.getDeliveryScope());
		model.addAttribute("deliveryCompanyDto",deliveryCompanyDto);
		return "admin/delivery-company-folder/delivery-company-register";
	}
	@PostMapping("/edit")
	public String editDelieryCompany(@Valid @ModelAttribute("deliveryCompanyDto")DeliveryCompanyDto deliveryCompanyDto,
			                  BindingResult result,@RequestParam("id")int id,Model model)
	{
		if(result.hasErrors())
		{
			return "admin/delivery-company-folder/delivery-company-register";
		}
		deliveryCompanyService.editDeliveryCompany(deliveryCompanyDto, id);
		return "redirect:/admin/delivery-companies";
	}
	@GetMapping("/delete")
	public String deleteDelieryCompany(@RequestParam("id")int id)
	{
		deliveryCompanyService.deleteDeliveryCompany(id);
		return "redirect:/admin/delivery-companies";
	}
	@GetMapping("/search")
	public String searchDelieryCompanyByCompanyName(@RequestParam("search")String search,Model model)
	{ 
		List<DeliveryCompany>deliveryCompanies = deliveryCompanyService.searchDeliveryCompanyByName(search);
		model.addAttribute("deliveryCompanies",deliveryCompanies);
		return "admin/delivery-company-folder/delivery-companies";
	}
	@GetMapping("/add-address")
	public String showAddAddressToDelieryCompanyPage(Model model,@RequestParam("id")int id)
	{
		DeliveryCompanyDto deliveryCompanyDto = new DeliveryCompanyDto();
		DeliveryCompany deliveryCompany = deliveryCompanyService.getDeliveryCompanyById(id);
		Address address = new Address();
		if(deliveryCompany.getDeliveryCompanyAddress()!=null)
		{
			address.setBuildingName(deliveryCompany.getDeliveryCompanyAddress().getBuildingName());
			address.setCity(deliveryCompany.getDeliveryCompanyAddress().getCity());
			address.setStreet(deliveryCompany.getDeliveryCompanyAddress().getStreet());
		}
		deliveryCompanyDto.setDeliveryCompanyAddress(address);
		model.addAttribute("deliveryCompanyDto",deliveryCompanyDto);
		return "admin/delivery-company-folder/delivery-company-address-register";
	}
	@PostMapping("/add-address")
	public String addAddressToDeliveryCompany(@ModelAttribute("deliveryCompanyDto")DeliveryCompanyDto deliveryCompanyDto,@RequestParam("id")int id)
	{
		deliveryCompanyService.addAddressToDeliveryCompany(deliveryCompanyDto, id);
		return "redirect:/admin/delivery-companies";
	}
}
