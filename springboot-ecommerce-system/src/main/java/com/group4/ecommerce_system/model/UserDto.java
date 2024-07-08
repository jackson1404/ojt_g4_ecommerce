package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {

	@NotEmpty(message = "Your name is required!")
	private String name;
	
	@NotEmpty(message = "Your email is required!")
	@Email
	private String email;
	
	@Size(min = 0, max = 8, message = "Password length must be between 0 and 8 characters!")
	@NotEmpty(message = "Your Password is required!")
	private String password;
	
	public int getPh_no() {
		return ph_no;
	}

	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}

	@NotEmpty(message = "Your phone must not be empty")
	private int ph_no;


	@NotEmpty(message = "Phone number is necessary to contact you!")
	private Address userAddress;
	
	private List<Order> orders;

	public UserDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public UserDto(@NotEmpty(message = "Your name is required!") String name,
			@NotEmpty(message = "Your email is required!") @Email String email,
			@Size(min = 0, max = 8, message = "Password length must be between 0 and 8 characters!") @NotEmpty(message = "Your Password is required!") String password,
			@NotEmpty(message = "Phone number is necessary to contact you!") Address userAddress, List<Order> orders) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userAddress = userAddress;
		this.orders = orders;
	}

}
