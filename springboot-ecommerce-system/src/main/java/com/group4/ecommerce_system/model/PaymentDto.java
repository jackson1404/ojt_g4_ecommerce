package com.group4.ecommerce_system.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PaymentDto {
	@NotEmpty(message = "Payment Date must not be empty!")
	private Date paymentDate;
	@NotEmpty(message = "Payment Method must not be empty!")
	private String paymentMethod;
	@Size(min = 0, message = "Payment amount cannot be 0.")
	private double paymentAmount;
	@NotEmpty(message = "Order payment must not be empty!")
	private List<Order> orderPayment;

	public PaymentDto() {
	}
	
	

	public PaymentDto(@NotEmpty(message = "Payment Date must not be empty!") Date paymentDate,
			@NotEmpty(message = "Payment Method must not be empty!") String paymentMethod,
			@Size(min = 0, message = "Payment amount cannot be 0.") double paymentAmount,
			@NotEmpty(message = "Order payment must not be empty!") List<Order> orderPayment) {
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

}
