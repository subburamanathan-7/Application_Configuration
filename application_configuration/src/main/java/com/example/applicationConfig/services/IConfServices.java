package com.example.applicationConfig.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfModel;
import com.example.applicationConfig.repository.ConfRepo;

@Service
public class IConfServices  implements ConfServices{
	

	@Autowired
	public ConfRepo confRepository;

	@Override
	public List<ConfModel> getAllConfigs()  throws NotFoundException{
		// TODO Auto-generated method stub
		List <ConfModel> configs = confRepository.findAll();
		if(configs.isEmpty()) {
			throw new NotFoundException("Configurations Not Found");
		}
		
		return configs.stream().map((config)->(config)).collect((Collectors.toList()));
	}

	@Override
	public ConfModel getConfig(String Id) throws NotFoundException  {
		// TODO Auto-generated method stub
		ConfModel config;
		if(confRepository.findByConfId(Id).isPresent()) {
			config = confRepository.findByConfId(Id).get();
		}
		else {
			throw new NotFoundException("Configuration Not Found");
		}
		
		return config;
	}

	@Override
	public ConfModel addConfig(ConfModel config)  throws AlreadyExistsException {
		// TODO Auto-generated method stub
		ConfModel newConfig;
		
		if(confRepository.findByConfName(config.getConfName()).isPresent()) {
			throw new AlreadyExistsException(" Configuration Exists.  Please Enter a new configuration");
		}
		newConfig = confRepository.save(config);
		return newConfig;
		
	}

	@Override
	public ConfModel updateConfig(String Id, ConfModel config) throws NotFoundException  {
		// TODO Auto-generated method stub
		ConfModel existingConfig;
		
		if(confRepository.findByConfId(Id).isPresent()) {
			existingConfig = confRepository.findByConfId(Id).get();
		}
		else {
			throw new NotFoundException("Configuration Not Found");
		}
		
		if(config.getConfStatus()!=null) {
			existingConfig.setConfStatus(config.getConfStatus());
		}
		if(config.getConfName()!=null) {
			existingConfig.setConfName(config.getConfName());
		}
		
		ConfModel updatedConfig= confRepository.save(existingConfig);
		return updatedConfig;
	}

	@Override
	public ConfModel deleteConfig(String Id) throws NotFoundException   {
		// TODO Auto-generated method stub
		ConfModel deletedConfig;
		
		if(confRepository.findByConfId(Id).isPresent()) {
			deletedConfig = confRepository.findByConfId(Id).get();
		}
		else {
			throw new NotFoundException("Configuration Not Found");
		}
		confRepository.deleteByConfId(Id);
		
		return deletedConfig;
	}
	
//
//	@Override
//	public ConfModel addConfigData(ConfModel config){
//		// TODO Auto-generated method stub
//		ConfModel newConfig;
//		
//		if(config.getConfType()== confTypes.INT) {
//			config.setConfIntData(config.getConfIntData());
//		}
//		
//		
//		return null;
//	}
//	

}
