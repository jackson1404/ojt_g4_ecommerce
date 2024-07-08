package com.group4.ecommerce_system.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_companies")
public class DeliveryCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryCompanyId;
	private String companyName;
	private String deliveryScope;
	private String deliveryCompanyEmail;
	
	@Embedded
	private Address deliveryCompanyAddress;
	
	@OneToOne(mappedBy = "deliveryCompany")
	private DeliveryInformation deliveryInformation;
	
	public DeliveryCompany() {
		
	}

	public DeliveryCompany(int deliveryCompanyId, String companyName, String deliveryScope,
			Address deliveryCompanyAddress, DeliveryInformation deliveryInformation,String deliveryCompanyEmail) {
		this.deliveryCompanyId = deliveryCompanyId;
		this.companyName = companyName;
		this.deliveryScope = deliveryScope;
		this.deliveryCompanyAddress = deliveryCompanyAddress;
		this.deliveryInformation = deliveryInformation;
		this.deliveryCompanyEmail = deliveryCompanyEmail;
	}

	public int getDeliveryCompanyId() {
		return deliveryCompanyId;
	}

	public void setDeliveryCompanyId(int deliveryCompanyId) {
		this.deliveryCompanyId = deliveryCompanyId;
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

	public String getDeliveryCompanyEmail() {
		return deliveryCompanyEmail;
	}

	public void setDeliveryCompanyEmail(String deliveryCompanyEmail) {
		this.deliveryCompanyEmail = deliveryCompanyEmail;
	}
	
}
