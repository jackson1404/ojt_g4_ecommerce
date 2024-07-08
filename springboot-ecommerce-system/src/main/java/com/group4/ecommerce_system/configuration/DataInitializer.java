package com.group4.ecommerce_system.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group4.ecommerce_system.service.roleService.RoleService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {

	@Autowired
	private RoleService roleService;
	
	@PostConstruct
	public void init()throws Exception{
		roleService.initializeRoles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
	}
}
