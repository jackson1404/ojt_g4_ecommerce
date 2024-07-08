package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import com.group4.ecommerce_system.model.DeliveryCompany;
import com.group4.ecommerce_system.model.DeliveryCompanyDto;

public interface AdminDeliveryCompanyService {
	List<DeliveryCompany> getAllDeliveryCompanies();
	DeliveryCompany getDeliveryCompanyById(int id);
	void createDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto);
	void editDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto,int id);
	void deleteDeliveryCompany(int id);
	List<DeliveryCompany> searchDeliveryCompanyByName(String search);
	void addAddressToDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto,int id);
}
