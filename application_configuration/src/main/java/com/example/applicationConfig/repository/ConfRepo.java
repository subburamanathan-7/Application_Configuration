package com.example.applicationConfig.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import  com.example.applicationConfig.models.ConfModel;

public interface ConfRepo extends MongoRepository<ConfModel, String> {


	Optional<ConfModel> findByConfId(String confId);
	Optional<ConfModel> deleteByConfId(String Id);
	
	
	Optional<ConfModel> findByConfName(String confName);

}