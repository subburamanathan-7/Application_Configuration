package com.example.applicationConfig.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.applicationConfig.models.RoleModel;

public interface RoleRepo extends MongoRepository<RoleModel, String> {
	
	Optional<RoleModel> findByRoleId(String roleId);

	Optional<RoleModel> findByAuthority(String authority);
	
}