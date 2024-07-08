package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class ShopDto {
	@NotEmpty(message = "Shop Brand name must not be empty!")
	private String shopBrandName;
	@NotEmpty(message = "Shop Email must not be empty!")
	private String shopEmail;
	@NotEmpty(message = "Shop address must not be empty!")
	private Address shopAddress;
	private List<Product>shopProducts;
	
	public ShopDto () {}
	
	public ShopDto(@NotEmpty(message = "Shop Brand name must not be empty!") String shopBrandName,
			@NotEmpty(message = "Shop Email must not be empty!") String shopEmail,
			@NotEmpty(message = "Shop address must not be empty!") Address shopAddress, List<Product> shopProducts) {
		super();
		this.shopBrandName = shopBrandName;
		this.shopEmail = shopEmail;
		this.shopAddress = shopAddress;
		this.shopProducts = shopProducts;
	}



	public String getShopBrandName() {
		return shopBrandName;
	}

	public void setShopBrandName(String shopBrandName) {
		this.shopBrandName = shopBrandName;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public Address getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}

	public List<Product> getShopProducts() {
		return shopProducts;
	}

	public void setShopProducts(List<Product> shopProducts) {
		this.shopProducts = shopProducts;
	}
	
	
}
