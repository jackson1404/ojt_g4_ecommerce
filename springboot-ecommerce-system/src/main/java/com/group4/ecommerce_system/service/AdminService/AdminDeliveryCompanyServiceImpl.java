package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Address;
import com.group4.ecommerce_system.model.DeliveryCompany;
import com.group4.ecommerce_system.model.DeliveryCompanyDto;
import com.group4.ecommerce_system.repository.DeliveryCompanyRepository;

@Service
public class AdminDeliveryCompanyServiceImpl implements AdminDeliveryCompanyService{

	@Autowired
	DeliveryCompanyRepository deliveryCompanyRepo;
	
	@Override
	public List<DeliveryCompany> getAllDeliveryCompanies() {
		return deliveryCompanyRepo.findAll();
	}

	@Override
	public DeliveryCompany getDeliveryCompanyById(int id) {
		return deliveryCompanyRepo.findById(id).orElse(null);
	}

	@Override
	public void createDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto) {
		DeliveryCompany deliveryCompany = new DeliveryCompany();
		Address address = new Address();
		deliveryCompany.setCompanyName(deliveryCompanyDto.getCompanyName());
		deliveryCompany.setDeliveryCompanyEmail(deliveryCompanyDto.getDeliveryCompanyEmail());
		deliveryCompany.setDeliveryScope(deliveryCompanyDto.getDeliveryScope());
		deliveryCompany.setDeliveryCompanyAddress(address);
		deliveryCompanyRepo.save(deliveryCompany);
	}

	@Override
	public void editDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto, int id) {
		DeliveryCompany deliveryCompany = getDeliveryCompanyById(id);
		deliveryCompany.setCompanyName(deliveryCompanyDto.getCompanyName());
		deliveryCompany.setDeliveryCompanyEmail(deliveryCompanyDto.getDeliveryCompanyEmail());
		deliveryCompany.setDeliveryScope(deliveryCompanyDto.getDeliveryScope());
		deliveryCompanyRepo.save(deliveryCompany);
	}

	@Override
	public void deleteDeliveryCompany(int id) {
		if(deliveryCompanyRepo.findById(id).isPresent())
		{
			deliveryCompanyRepo.deleteById(id);
		}
	}

	@Override
	public List<DeliveryCompany> searchDeliveryCompanyByName(String search) {
		return deliveryCompanyRepo.findByCompanyNameContainingIgnoreCase(search);
	}

	@Override
	public void addAddressToDeliveryCompany(DeliveryCompanyDto deliveryCompanyDto, int id) {
		DeliveryCompany deliveryCompany = getDeliveryCompanyById(id);
		Address address = new Address();
		address.setBuildingName(deliveryCompanyDto.getDeliveryCompanyAddress().getBuildingName());
		address.setCity(deliveryCompanyDto.getDeliveryCompanyAddress().getCity());
		address.setStreet(deliveryCompanyDto.getDeliveryCompanyAddress().getStreet());
		deliveryCompany.setDeliveryCompanyAddress(address);
		deliveryCompanyRepo.save(deliveryCompany);
	}
}
