package com.group4.ecommerce_system.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;

	private Date paymentDate;
	private String paymentMethod;
	private double paymentAmount;

	@OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
	private List<Order> orderPayment;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Payment(int paymentId, Date paymentDate, String paymentMethod, double paymentAmount,
			List<Order> orderPayment) {
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.orderPayment = orderPayment;
	}

	public List<Order> getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(List<Order> orderPayment) {
		this.orderPayment = orderPayment;
	}

	public Payment() {

	}
}
