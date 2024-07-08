package com.group4.ecommerce_system.service.roleService;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.group4.ecommerce_system.model.Role;
import com.group4.ecommerce_system.repository.RoleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public void initializeRoles(List<String> roles) throws Exception {
		for(String roleName : roles) {
			try {
				if(roleRepository.findByName(roleName).isEmpty()) {
					Role role = new Role();
					role.setName(roleName);
					roleRepository.save(role);
					logger.info("Role {} has been inserted." , roleName);
				}else {
					logger.info("Role {} already exist." , roleName);
				}
		
		}catch (DataAccessException e) {
			logger.error("Database access error while inserting role {} : {} ", roleName, e.getMessage());
			throw new Exception("Error while accessing the database for role: " + roleName, e);
		}
			catch(Exception e) {
				logger.error("Unexpected error while inserting role {} : {} ", roleName, e.getMessage());
				throw new Exception("Error while accessing the database for role: " + roleName, e);
			
			}
	}

}
}
