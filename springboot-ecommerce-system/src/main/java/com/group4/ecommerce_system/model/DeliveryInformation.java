package com.group4.ecommerce_system.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_informations")
public class DeliveryInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryInformationId;

	private String waitingStatus;

	private String deliveryServiceName;
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_company_id")
	private DeliveryCompany deliveryCompany;
	
	@OneToOne(mappedBy = "deliveryInformation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Order orderDeliveryInfo;

	public int getDeliveryInformationId() {
		return deliveryInformationId;
	}

	public void setDeliveryInformationId(int deliveryInformationId) {
		this.deliveryInformationId = deliveryInformationId;
	}

	public String getWaitingStatus() {
		return waitingStatus;
	}

	public void setWaitingStatus(String waitingStatus) {
		this.waitingStatus = waitingStatus;
	}

	public String getDeliveryServiceName() {
		return deliveryServiceName;
	}

	public void setDeliveryServiceName(String deliveryServiceName) {
		this.deliveryServiceName = deliveryServiceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Order getOrderDeliveryInfo() {
		return orderDeliveryInfo;
	}

	public void setOrderDeliveryInfo(Order orderDeliveryInfo) {
		this.orderDeliveryInfo = orderDeliveryInfo;
	}
	
	public DeliveryInformation(int deliveryInformationId, String waitingStatus, String deliveryServiceName,
			String description, DeliveryCompany deliveryCompany, Order orderDeliveryInfo) {
		this.deliveryInformationId = deliveryInformationId;
		this.waitingStatus = waitingStatus;
		this.deliveryServiceName = deliveryServiceName;
		this.description = description;
		this.deliveryCompany = deliveryCompany;
		this.orderDeliveryInfo = orderDeliveryInfo;
	}

	public DeliveryInformation() {
		
	}

	public DeliveryCompany getDeliveryCompany() {
		return deliveryCompany;
	}

	public void setDeliveryCompany(DeliveryCompany deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	
}
