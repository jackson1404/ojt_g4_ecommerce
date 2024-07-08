package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;
	private String shopBrandName;
	private String shopEmail;
	
	@Embedded
	private Address shopAddress;

	@OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product>shopProducts;

	public Shop() {
		
	}
	
	public Shop(int shopId, String shopBrandName, String shopEmail, Address shopAddress,
			List<Product> shopProducts) {
		this.shopId = shopId;
		this.shopBrandName = shopBrandName;
		this.shopEmail = shopEmail;
		this.shopAddress = shopAddress;
		this.shopProducts = shopProducts;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
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
