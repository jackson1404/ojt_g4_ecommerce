package com.group4.ecommerce_system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productName;
	private String productBrand;
	private double productPrice;
	private String productImageFileName;
	private String description;
	private int quantity;
	private boolean seen;

	public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
	
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> productOrders;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "categories_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_id")
	private Shop shop;
	
	 @ManyToMany(mappedBy = "cartProducts")
	    private List<Cart> carts;




	public Product() {
		
	}

	

	

	public Product(int productId, String productName, String productBrand, double productPrice,
			String productImageFileName, String description, int quantity, boolean seen, List<Order> productOrders,
			Category category, Shop shop, List<Cart> carts) {
		this.productId = productId;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productImageFileName = productImageFileName;
		this.description = description;
		this.quantity = quantity;
		this.seen = seen;
		this.productOrders = productOrders;
		this.category = category;
		this.shop = shop;
		this.carts = carts;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageFileName() {
		return productImageFileName;
	}

	public void setProductImageFileName(String productImageFileName) {
		this.productImageFileName = productImageFileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Order> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<Order> productOrders) {
		this.productOrders = productOrders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
}
