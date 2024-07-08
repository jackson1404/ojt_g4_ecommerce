package com.group4.ecommerce_system.model;

import jakarta.validation.constraints.NotEmpty;

public class DeliveryCompanyDto {
	@NotEmpty(message = "Company Name must not be empty!")
	private String companyName;
	@NotEmpty(message = "Delivery Scope must not be empty!")
	private String deliveryScope;
	@NotEmpty(message = "Delivery Company Email must not be empty!")
	private String deliveryCompanyEmail;
	@NotEmpty(message = "Delivery Company Address must not be empty!")
	private Address deliveryCompanyAddress;
	
	@NotEmpty(message = "Delivery Information must not be empty!")
	private DeliveryInformation deliveryInformation;
	
	public DeliveryCompanyDto() {}

	
	
	public DeliveryCompanyDto(@NotEmpty(message = "Company Name must not be empty!") String companyName,
			@NotEmpty(message = "Delivery Scope must not be empty!") String deliveryScope,
			@NotEmpty(message = "Delivery Company Email must not be empty!") String deliveryCompanyEmail,
			@NotEmpty(message = "Delivery Company Address must not be empty!") Address deliveryCompanyAddress,
			@NotEmpty(message = "Delivery Information must not be empty!") DeliveryInformation deliveryInformation) {
		this.companyName = companyName;
		this.deliveryScope = deliveryScope;
		this.deliveryCompanyEmail = deliveryCompanyEmail;
		this.deliveryCompanyAddress = deliveryCompanyAddress;
		this.deliveryInformation = deliveryInformation;
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeliveryScope() {
		return deliveryScope;
	}

	public void setDeliveryScope(String deliveryScope) {
		this.deliveryScope = deliveryScope;
	}

	public String getDeliveryCompanyEmail() {
		return deliveryCompanyEmail;
	}

	public void setDeliveryCompanyEmail(String deliveryCompanyEmail) {
		this.deliveryCompanyEmail = deliveryCompanyEmail;
	}

	public Address getDeliveryCompanyAddress() {
		return deliveryCompanyAddress;
	}

	public void setDeliveryCompanyAddress(Address deliveryCompanyAddress) {
		this.deliveryCompanyAddress = deliveryCompanyAddress;
	}

	public DeliveryInformation getDeliveryInformation() {
		return deliveryInformation;
	}

	public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
		this.deliveryInformation = deliveryInformation;
	}
	
	
}
