package com.example.applicationConfig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.DataMisMatchException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfDataModel;
import com.example.applicationConfig.models.ConfDataModel.confTypes;
import com.example.applicationConfig.repository.ConfDataRepo;

@Service
public class IConfDataServices  implements ConfDataServices{

	@Autowired
	private PasswordEncoder encoder;
	 
	@Autowired
	public ConfDataRepo confDataRepository;
	
	@Override
	public ConfDataModel getConfigData(String confId) throws NotFoundException {
		// TODO Auto-generated method stub
		ConfDataModel confData;
		if(confDataRepository.findByConfId(confId).isPresent()) {
			confData = confDataRepository.findByConfId(confId).get();
		}
		else {
			throw new NotFoundException("Configuration Not Found");
		}
		
		return confData;
	}

	@Override
	public ConfDataModel addConfigData(ConfDataModel configdata) throws DataMisMatchException ,AlreadyExistsException{
		// TODO Auto-generated method stub
		
		if(confDataRepository.findByConfId(configdata.getConfId()).isPresent()) {
			System.out.println("Config Exisits");
			confDataRepository.deleteByConfId(configdata.getConfId());
		}
		
		if(configdata.getConfType()==confTypes.INT) {
			configdata.setConfBoolData(null);
			configdata.setConfStrData(null);
		}
		else if(configdata.getConfType()==confTypes.BOOLEAN) {
			configdata.setConfIntData(null);
			configdata.setConfStrData(null);
		}
		else if(configdata.getConfType()==confTypes.STRING) {
			configdata.setConfBoolData(null);
			configdata.setConfIntData(null);
		}
		else {
			configdata.setConfBoolData(null);
			configdata.setConfStrData(null);
			configdata.setConfIntData(null);
			throw new DataMisMatchException("Configuration DataInputMismatch");
		}
		ConfDataModel newConfData = confDataRepository.save(configdata);
				
		return newConfData;
	}

	
	

}
