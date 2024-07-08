package com.group4.ecommerce_system.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DeliveryInformationDto {
	@NotEmpty(message = "Waiting status is required!")
	private String waitingStatus;

	@NotEmpty(message = "Delivery Service Company name is required!")
	private String deliveryServiceName;
	
	@Size(min = 0,message = "Desciption field must not be empty!")
	@Size(max = 100,message = "Description must be less than 100 characters!")
	private String description;
	
	private Order orderDeliveryInfo;

	public DeliveryInformationDto() {
		
	}
	
	public DeliveryInformationDto(@NotEmpty(message = "Waiting status is required!") String waitingStatus,
			@NotEmpty(message = "Delivery Service Company name is required!") String deliveryServiceName,
			@Size(min = 0, message = "Desciption field must not be empty!") @Size(max = 100, message = "Description must be less than 100 characters!") String description,
			Order orderDeliveryInfo) {
		this.waitingStatus = waitingStatus;
		this.deliveryServiceName = deliveryServiceName;
		this.description = description;
		this.orderDeliveryInfo = orderDeliveryInfo;
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
	
}
