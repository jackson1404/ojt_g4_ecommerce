package com.group4.ecommerce_system.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private Date orderDate;
	private double totalPrice;
	private int orderQuantity;

	private String status;

	
	public Order(int orderId, Date orderDate, double totalPrice, int orderQuantity, String status,
			User customerOrder, DeliveryInformation deliveryInformation, OrderHistory orderHistory,
			List<Product> products, Payment payment, Cart orderCart) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderQuantity = orderQuantity;
		this.status = status;
		this.customerOrder = customerOrder;
		this.deliveryInformation = deliveryInformation;
		this.orderHistory = orderHistory;
		this.products = products;
		this.payment = payment;
		this.orderCart = orderCart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private User customerOrder;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_information_id")
	private DeliveryInformation deliveryInformation;

	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private OrderHistory orderHistory;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart orderCart;

	public Cart getOrderCart() {
		return orderCart;
	}

	public void setOrderCart(Cart orderCart) {
		this.orderCart = orderCart;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public User getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(User customerOrder) {
		this.customerOrder = customerOrder;
	}

	public DeliveryInformation getDeliveryInformation() {
		return deliveryInformation;
	}

	public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
		this.deliveryInformation = deliveryInformation;
	}

	public OrderHistory getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(OrderHistory orderHistory) {
		this.orderHistory = orderHistory;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Order() {

	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	 public void addProduct(Product product, int quantity) {
	        for (Product p : products) {
	            if (p.getProductId() == product.getProductId()) {
	                p.setQuantity(p.getQuantity() + quantity);
	                return;
	            }
	        }
	        product.setQuantity(quantity);
	        products.add(product);
	    }

	 public void removeProduct(Product product) {
	        products.removeIf(p -> p.getProductId() == product.getProductId());
	    }

	    public void updateProductQuantity(Product product, int quantity) {
	        for (Product p : products) {
	            if (p.getProductId() == product.getProductId()) {
	                p.setQuantity(quantity);
	                break;
	            }
	        }
	    }
}
