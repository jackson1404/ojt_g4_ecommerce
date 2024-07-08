package com.group4.ecommerce_system.service.roleService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RoleService {
	void initializeRoles(List<String>roles) throws Exception;
}
