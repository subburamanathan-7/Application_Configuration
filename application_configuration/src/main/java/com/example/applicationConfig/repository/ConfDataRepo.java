package com.example.applicationConfig.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.applicationConfig.models.ConfDataModel;


public interface ConfDataRepo extends MongoRepository<ConfDataModel, String>  {


		Optional<ConfDataModel> findByConfId(String confId);
		Optional<ConfDataModel> findByConfDataId(String confDataId);
		Optional<ConfDataModel> deleteByConfId(String Id);
		
		
}



