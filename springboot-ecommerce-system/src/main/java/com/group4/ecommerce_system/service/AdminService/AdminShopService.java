package com.group4.ecommerce_system.service.AdminService;

import java.util.List;

import com.group4.ecommerce_system.model.Shop;
import com.group4.ecommerce_system.model.ShopDto;

public interface AdminShopService {
	List<Shop> getAllShops();
	Shop getShopById(int id);
	void createShop(ShopDto shopDto);
	void editShop(ShopDto shopDto,int id);
	void deleteShop(int id);
	List<Shop> searchShopsByName(String shopName);
	void addProductToShop(ShopDto shopDto,int id);
	void addAddressToShop(ShopDto shopDto,int id);
}
