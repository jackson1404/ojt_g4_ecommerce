package com.group4.ecommerce_system.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Address;
import com.group4.ecommerce_system.model.Product;
import com.group4.ecommerce_system.model.Shop;
import com.group4.ecommerce_system.model.ShopDto;
import com.group4.ecommerce_system.repository.ProductRepository;
import com.group4.ecommerce_system.repository.ShopRepository;

@Service
public class AdminShopServiceImpl implements AdminShopService {
	@Autowired
	private ShopRepository shopRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Shop> getAllShops() {
		return shopRepo.findAll();
	}

	@Override
	public Shop getShopById(int id) {
		return shopRepo.findById(id).orElse(null);
	}

	@Override
	public void createShop(ShopDto shopDto) {
		Shop shop = new Shop();
		Address address = new Address();
		shop.setShopBrandName(shopDto.getShopBrandName());
		shop.setShopEmail(shopDto.getShopEmail());
		shop.setShopAddress(address);
		shopRepo.save(shop);
	}

	@Override
	public void editShop(ShopDto shopDto, int id) {
		Shop shop = shopRepo.findById(id).orElse(null);
		shop.setShopBrandName(shopDto.getShopBrandName());
		shop.setShopEmail(shopDto.getShopEmail());
		shopRepo.save(shop);
	}

	@Override
	public void deleteShop(int id) {
		if(shopRepo.findById(id).isPresent())
		{
			Shop shop = shopRepo.findById(id).orElse(null);
			List<Product> products = productRepo.findByShop(shop);
			for(Product product : products)
			{
				product.setShop(null);
			}
			shopRepo.deleteById(id);
		}
	}

	@Override
	public List<Shop> searchShopsByName(String search) {
		return shopRepo.findByShopBrandNameContainingIgnoreCase(search);
	}

	@Override
	public void addProductToShop(ShopDto shopDto, int id) {
		Shop shop = shopRepo.findById(id).orElse(null);
		if (shop == null) 
		{
	        throw new RuntimeException("Category not found");
	    }
		List<Product> products = productRepo.findAllById(shopDto.getShopProducts().stream().map(Product::getProductId).collect(Collectors.toList()));
		for(Product product : products)
		{
			product.setShop(shop);
			productRepo.save(product);
		}
		shop.setShopProducts(products);
		shopRepo.save(shop);
	}

	@Override
	public void addAddressToShop(ShopDto shopDto, int id) {
		Shop shop = getShopById(id);
		Address address = new Address();
		address.setBuildingName(shopDto.getShopAddress().getBuildingName());
		address.setCity(shopDto.getShopAddress().getCity());
		address.setStreet(shopDto.getShopAddress().getStreet());
		shop.setShopAddress(address);
		shopRepo.save(shop);
	}
}
