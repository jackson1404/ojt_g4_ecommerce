package com.group4.ecommerce_system.customerController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group4.ecommerce_system.model.User;
import com.group4.ecommerce_system.model.UserDto;
import com.group4.ecommerce_system.model.Address;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.service.CustomerProductService;
import com.group4.ecommerce_system.service.CustomerService;
import com.group4.ecommerce_system.service.AdminService.AdminProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class StartController {

	@Autowired
	private CustomerProductService productService;

	@Autowired
	private AdminProductService adminproductService;

//	@Autowired
//	private CustomerLoginService customerLoginService;

	@Autowired
	private CustomerService customerService;

	@GetMapping({ "/customerIndex"})

	public String index() {

		return "customer/customerIndex";
	}
	
	
	@GetMapping({"/"})

	public String redirectIndex() {

		return "redirect:customerIndex";
	}
	
	@GetMapping({""})

	public String redirectCustomerIndex() {

		return "redirect:customer/customerIndex";
	}

	@GetMapping("/about")
	public String showAboutPage() {
		return "customer/about";
	}

	@GetMapping("/product")
	public String showProductsInUI(@RequestParam(value = "q", required = false) String query, Model model) {
		List<Product> products = productService.getAllProducts(); // Fetch all products from your service

		if (query != null && !query.isEmpty()) {
			products = products.stream()
					.filter(product -> product.getProductName().toLowerCase().contains(query.toLowerCase())
							|| product.getProductBrand().toLowerCase().contains(query.toLowerCase()))
					.collect(Collectors.toList());
		}

		model.addAttribute("products", products);
		return "/customer/product"; // This is your Thymeleaf template name (product.html)
	}

	@GetMapping("/contact")
	public String showContactPage() {
		return "customer/contact";
	}

	@GetMapping("/orderHistory")
	public String showOrderHistoryPage() {
		return "customer/orderHistory";
	}

	@GetMapping("/productDetail/{id}")
	public String showProductDetailPage(@PathVariable("id") int productId, Model model) {
		Product product = adminproductService.getProductById(productId);
		model.addAttribute("product", product);
		return "customer/productDetail";
	}

	@GetMapping("/menProduct")
	public String showMenProductPage() {
		return "customer/menProduct";
	}

	@GetMapping("/womenProduct")
	public String showWomenProductPage() {
		return "customer/womenProduct";
	}

	@GetMapping("/sneakerProduct")
	public String showSneakerProductPage() {
		return "customer/sneakerProduct";
	}

	@GetMapping("/tshirtProduct")
	public String showTshirtProductPage() {
		return "customer/tshirtProduct";
	}

	@GetMapping("/pantProduct")
	public String showPantProductPage() {
		return "customer/pantProduct";
	}

	@GetMapping("/profile")
	public String showProfilePage() {
		return "customer/profile";
	}

	@GetMapping("/order")
	public String showOrderPage() {
		return "customer/placeOrder";
	}

	@GetMapping("/create")
	public String createCustomer(Model model) {
		UserDto customerDto = new UserDto();
		model.addAttribute("customerDto", customerDto);
		return "customer/createCustomer";
	}

	@PostMapping("/create")
	public String createCustomer(@ModelAttribute UserDto customerDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "customer/createCustomer";
		}
		customerService.createCustomer(customerDto);
		return "redirect:/customer";
	}

	@GetMapping("/edit_customer")
	public String editCustomer(Model model, @RequestParam("customerId") int customerId) {
		User customer = customerService.getAllCustomer().stream().filter(c -> c.getId() == customerId)
				.findFirst().orElseThrow(() -> new RuntimeException("Customer not found"));
		UserDto customerDto = new UserDto();
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		model.addAttribute("customerDto", customerDto);
		return "/customers/edit_customer";

	}

	@PostMapping("/edit_customer")
	public String editCustomer(@ModelAttribute("customerDto") UserDto customerDto, Model model,
			@RequestParam("customerId") int customerId) {
		customerService.editCustomer(customerId, customerDto);
		return "redirect:/customers?customerId=" + customerId;

	}

	@GetMapping("/add_address")
	public String createAddress(Model model) {
		UserDto customerDto = new UserDto();
		User customer = new User();
		Address address = new Address();
		if (customer.getUserAddress() != null) {
			address.setBuildingName(customer.getUserAddress().getBuildingName());
			address.setCity(customer.getUserAddress().getCity());
			address.setStreet(customer.getUserAddress().getStreet());
		}
		customerDto.setUserAddress(address);
		model.addAttribute("customerDto", customerDto);
		return "customers/customer_address";
	}

	@PostMapping("/add_address")
	public String createAddress(@ModelAttribute("customerDto") UserDto customerDto,
			@RequestParam("customerId") int customerId) {
		customerService.addAddress(customerDto, customerId);
		return "redirect:/customers?customerId=" + customerId;
	}

	@GetMapping("/edit_address")
	public String showEditAddressForm(@RequestParam("customerId") int customerId, Model model) {
		User customer = customerService.getCustomerById(customerId);
		UserDto customerDto = new UserDto();
		customerDto.setUserAddress(customer.getUserAddress()); // Set current address for editing
		model.addAttribute("customerDto", customerDto);
		model.addAttribute("customerId", customerId);
		return "customers/edit_address";
	}

	// Handle POST request to edit address
	@PostMapping("/edit_address")
	public String editAddress(@ModelAttribute("customerDto") UserDto customerDto, BindingResult result, Model model,
			@RequestParam("customerId") int customerId) {
		if (result.hasErrors()) {
			return "customers/edit_address";
		}
		customerService.editAddress(customerDto, customerId);
		return "redirect:/customers?customerId=" + customerId;
	}

//	@GetMapping("/login")
//	public String getStudentPage(HttpSession session, Model model) {
//		User customer = (User) session.getAttribute("user");
//		model.addAttribute("customer", customer);
//		return "customer/login";
//	}

//	@PostMapping("/login")
//	public String login(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword,
//			HttpSession session) {
//		User customer = customerLoginService.authenticate(userEmail, userPassword);
//		if (customer != null) {
//
//			session.setAttribute("customer", customer);
//
//			return "redirect:/customer";
//		} else {
//			return "redirect:/customer/login";
//		}
//	}

	@SuppressWarnings("unchecked")
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
		}
		if (!cart.contains(productId)) {
			cart.add(productId);
			Product product = adminproductService.getProductById(productId);
			product.setSeen(true); // set seen to true
		}
		session.setAttribute("cart", cart);
		return "redirect:/customer/cart";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/cart")
	public String showCart(Model model, HttpSession session) {
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		List<Product> products = new ArrayList<>();
		if (cart != null) {
			for (Integer productId : cart) {
				Product product = adminproductService.getProductById(productId);
				if (product != null) {
					product.setSeen(true); // set seen to true
					products.add(product);
				}
			}
		}
		model.addAttribute("products", products);
		return "customer/cart";
	}

}
