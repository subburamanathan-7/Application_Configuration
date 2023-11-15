package com.example.applicationConfig.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import  com.example.applicationConfig.models.UserModel;

public interface UserRepo extends MongoRepository<UserModel, String> {


	Optional<UserModel> findByUserId(String userId);
	
	Optional<UserModel> findByUsername(String username);
}