package com.example.applicationConfig.services;
import java.util.List;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfModel;

public interface ConfServices {
	
	List <ConfModel> getAllConfigs() throws NotFoundException;
	ConfModel getConfig (String Id) throws NotFoundException;
	
	ConfModel addConfig (ConfModel config) throws AlreadyExistsException;
	ConfModel updateConfig (String Id, ConfModel config);
	ConfModel deleteConfig (String Id);
	

}
