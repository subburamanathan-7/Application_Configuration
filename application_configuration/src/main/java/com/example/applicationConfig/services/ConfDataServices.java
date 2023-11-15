package com.example.applicationConfig.services;

import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfDataModel;

public interface ConfDataServices {

	ConfDataModel getConfigData (String confId) throws NotFoundException;
	ConfDataModel addConfigData (ConfDataModel configdata);
}
